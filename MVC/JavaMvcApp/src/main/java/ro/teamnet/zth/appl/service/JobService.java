package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.domain.Job;

import java.util.List;

/**
 * Created by FFA on 16.07.2016.
 */
public interface JobService {

    public List<Job> findAllJobs();
}
