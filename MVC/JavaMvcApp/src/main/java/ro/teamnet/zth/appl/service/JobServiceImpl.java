package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.dao.JobDao;
import ro.teamnet.zth.appl.domain.Job;

import java.util.List;

/**
 * Created by FFA on 16.07.2016.
 */
public class JobServiceImpl implements JobService {
    JobDao jobDao=new JobDao();

    @Override
    public List<Job> findAllJobs() {
        return jobDao.getAllJobs();
    }
}
