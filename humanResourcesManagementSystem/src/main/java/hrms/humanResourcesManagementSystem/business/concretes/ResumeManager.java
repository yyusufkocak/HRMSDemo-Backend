package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.CoverLetterService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobExperienceService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerEducationService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerLanguageService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerSkillService;
import hrms.humanResourcesManagementSystem.business.abstracts.LinkService;
import hrms.humanResourcesManagementSystem.business.abstracts.ResumeService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.ResumeDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Resume;
import hrms.humanResourcesManagementSystem.entities.dtos.ResumeWithAllRelatedEntitiesDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private JobSeekerService jobSeekerService;
	private CoverLetterService coverLetterService;
	private JobSeekerEducationService jobSeekerEducationService;
	private JobExperienceService jobExperienceService;
	private JobSeekerLanguageService jobSeekerLanguageService;
	private JobSeekerSkillService jobSeekerSkillService;
	private LinkService linkService;

	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, JobSeekerService jobSeekerService, CoverLetterService coverLetterService,
			JobSeekerEducationService jobSeekerEducationService, JobExperienceService jobExperienceService,
			JobSeekerLanguageService jobSeekerLanguageService, JobSeekerSkillService jobSeekerSkillService,LinkService linkService) {
		this.resumeDao = resumeDao;
		this.jobSeekerService = jobSeekerService;
		this.coverLetterService = coverLetterService;
		this.jobSeekerEducationService = jobSeekerEducationService;
		this.jobExperienceService = jobExperienceService;
		this.jobSeekerLanguageService = jobSeekerLanguageService;
		this.jobSeekerSkillService = jobSeekerSkillService;
		this.linkService=linkService;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll());
	}

	@Override
	public DataResult<Resume> getById(int resumeId) {
		return new SuccessDataResult<Resume>(resumeDao.getById(resumeId));
	}

	@Override
	public Result add(Resume resume) {
		resumeDao.save(resume);
		return new SuccessResult("Resume added");
	}

	@Override
	public Result delete(Resume resume) {
		resumeDao.delete(resume);
		return new SuccessResult("Resume deleted");
	}

	@Override
	public DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByJobSeekerId(int jobSeekerId) {

		ResumeWithAllRelatedEntitiesDto resumeWithAllRelatedEntitiesDto = new ResumeWithAllRelatedEntitiesDto(
		
		getByJobSeekerId(jobSeekerId).getData().getId(),
		jobSeekerService.getById(jobSeekerId).getData().getFirstName(),
		jobSeekerEducationService.getAllByJobSeekerIdOrderByEndingDateDesc(jobSeekerId).getData(),
		jobSeekerSkillService.getAllByJobSeekerId(jobSeekerId).getData(),
		linkService.getAllByJobSeekerId(jobSeekerId).getData(),
		jobExperienceService.getAllByJobSeekerIdOrderByEndingDateDesc(jobSeekerId).getData(),		
		jobSeekerLanguageService.getAllByJobSeekerId(jobSeekerId).getData(),
		coverLetterService.getAllByJobSeekerId(jobSeekerId).getData()
		
				);
		return new SuccessDataResult<ResumeWithAllRelatedEntitiesDto>(resumeWithAllRelatedEntitiesDto);
		
	}

	@Override
	public DataResult<Resume> getByJobSeekerId(int jobseekerId) {
		return new SuccessDataResult<Resume>(resumeDao.getByJobSeeker_Id(jobseekerId));
	}



}
