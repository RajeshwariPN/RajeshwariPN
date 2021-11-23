package com.infotech.flexibautomation.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.infotech.flexibautomation.dto.AvokaResponseDto;
import com.infotech.flexibautomation.dto.SearchCriteriaDTO;
import com.infotech.flexibautomation.entity.AvokaResults;
import com.infotech.flexibautomation.repo.AutoDateFilterRepo;

@Service
@Transactional
public class AvokaResultsService {

	@Autowired
	private AutoDateFilterRepo autoDateFilterRepo;
	
	public AvokaResponseDto getAvokaResults(SearchCriteriaDTO criteria) {
		
		AvokaResponseDto response = new  AvokaResponseDto();
		PageRequest page = this.getPageRequest(criteria.getPageNo().toString(), criteria.getPageSize().toString()  );
		
		if(page == null)
			return response;
		
		Specification<AvokaResults> avokaResultsSpec = getAvokaResultsSpec(criteria);
		
		
		Integer totalRecords = (int)autoDateFilterRepo.count(avokaResultsSpec);
		response.setTotalRecords(totalRecords);
		
		Page<AvokaResults> pageContract = autoDateFilterRepo.findAll(avokaResultsSpec, page);
		
		List<AvokaResults> theAvokaResultsList = pageContract.getContent();
		response.setData(theAvokaResultsList);
		
		this.setPaginationData(response, criteria);
		
		return response;
	}
	
	private Specification<AvokaResults> getAvokaResultsSpec(SearchCriteriaDTO criteria) {
		return (root, query, criteriaBuilder) -> {
			
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

			return criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("dateExecuted"), fromDate),
					criteriaBuilder.lessThanOrEqualTo(root.get("dateExecuted"), toDate),
					criteria.getStatus().equals("all") ? criteriaBuilder.and() : 
						criteriaBuilder.equal(root.get("status"), criteria.getStatus()));
			
		};
			
			/*return criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("dateExecuted"), fromDate),
			criteriaBuilder.lessThanOrEqualTo(root.get("dateExecuted"), toDate),
			//criteria.getStatus().equals("all") ? criteriaBuilder.and() : 
				//criteriaBuilder.equal(root.get("status"), criteria.getStatus()),
				criteria.getStatus().equals("PASS") ? criteriaBuilder.and() : 
					//criteriaBuilder.equal(root.get("status"), criteria.getStatus()),
					//criteria.getStatus().equals("FAIL") ? criteriaBuilder.and() : 
						//criteriaBuilder.equal(root.get("status"), criteria.getStatus()),
						//criteria.getStatus().equals("SKIP") ? criteriaBuilder.and() : 
							criteriaBuilder.equal(root.get("status"), criteria.getStatus()));
	
};*/
	}
	
	
	private void setPaginationData(AvokaResponseDto dto, SearchCriteriaDTO criteriaDTO) {
		boolean isLast = Boolean.FALSE;
		boolean isFirst = Boolean.FALSE;
		int totalPages = (dto.getTotalRecords() / criteriaDTO.getPageSize());
		int remValue = (dto.getTotalRecords() % criteriaDTO.getPageSize());
		if (remValue > 0) {
			totalPages = totalPages + 1;
		}
		int lastPage = totalPages - 1;
		if (criteriaDTO.getPageNo() == 0) {
			isFirst = Boolean.TRUE;
		}
		if (lastPage == criteriaDTO.getPageNo()) {
			isLast = Boolean.TRUE;
		}
		dto.setTotalpages(totalPages);
		dto.setFirst(isFirst);
		dto.setLast(isLast);
		dto.setCurrentPage(criteriaDTO.getPageNo());
	}

	@SuppressWarnings("deprecation")
	private PageRequest getPageRequest(String pageNo, String pageSize) {
		PageRequest page = null;
		if (StringUtils.isEmpty(pageNo) || StringUtils.isEmpty(pageSize))
			return null;
		page = PageRequest.of(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		return page;

	}

}
