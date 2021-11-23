package com.infotech.flexibautomation.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.flexibautomation.dto.PerfDashboardCountDTO;
import com.infotech.flexibautomation.dto.PerformanceDashboardErrorCountDTO;
import com.infotech.flexibautomation.repo.JmeterResultsPerfCountRepo;

@Service
public class PerformanceDashboardService {

	@Autowired
	private JmeterResultsPerfCountRepo jmeterResultsPerfCountRepo;
	
	
	public PerformanceDashboardErrorCountDTO getStatusCount(PerfDashboardCountDTO criteria) {
		
		SimpleDateFormat dateFormater=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp());
		//String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		
		Date fromDate = null;
		try {
			fromDate = dateFormater.parse(criteria.getFromDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date toDate = null;
		try {
			toDate = dateFormater.parse(criteria.getToDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		PerformanceDashboardErrorCountDTO responce = new PerformanceDashboardErrorCountDTO();
		responce.setTotalCount(jmeterResultsPerfCountRepo.getTotalCount(fromDate,toDate));
		responce.setPassCount(jmeterResultsPerfCountRepo.getPassedCount(fromDate,toDate));
		responce.setFailedCount(jmeterResultsPerfCountRepo.getFailedCount(fromDate,toDate));
		return responce;
		
		
		
	}

}
