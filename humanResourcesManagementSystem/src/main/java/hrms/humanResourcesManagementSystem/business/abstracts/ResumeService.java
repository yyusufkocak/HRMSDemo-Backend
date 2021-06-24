package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Resume;
import hrms.humanResourcesManagementSystem.entities.dtos.ResumeWithAllRelatedEntitiesDto;

public interface ResumeService {

	DataResult<List<Resume>> getAll();
	
	DataResult<Resume> getById(int resumeId);
	
	Result add (Resume resume) ;
	
	Result delete (Resume resume) ;
	
	DataResult<Resume> getByJobSeekerId(int jobseekerId);
	
	
	
	DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByJobSeekerId(int jobSeekerId);
	
}
