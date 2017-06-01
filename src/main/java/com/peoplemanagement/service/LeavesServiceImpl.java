package com.peoplemanagement.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplemanagement.exception.PeopleManagementException;
import com.peoplemanagement.model.Leaves;
import com.peoplemanagement.repository.LeavesRepository;

@Service
@Transactional
public class LeavesServiceImpl implements LeavesService {

	@Autowired
	LeavesRepository leaveRepository;

	@Override
	public boolean addLeaves(Leaves leave) throws PeopleManagementException {
		if (this.validateLeaves(leave)) {
			this.leaveRepository.save(leave);
			return true;
		} else {
			throw new PeopleManagementException("You are running out of leaves");
		}
	}

	@Override
	public boolean validateLeaves(Leaves leave) {

		List<Leaves> allLeaves = this.leaveRepository.findByPerson(leave.getPerson());
		if (allLeaves.isEmpty()) {
			return true;
		}
		Leaves leaveTemp;
		int totalLeaves = 0;
		Iterator<Leaves> iterator = allLeaves.iterator();
		while (iterator.hasNext()) {
			leaveTemp = iterator.next();
			totalLeaves += getDifferenceDays(leaveTemp.getStartDate(), leaveTemp.getEndDate());			
		}
		if (totalLeaves < 20) {
			totalLeaves += getDifferenceDays(leave.getStartDate(), leave.getEndDate());
			if (totalLeaves < 20) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void truncate() {
		this.leaveRepository.deleteAll();
	}

	public static long getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+1;
	}
}
