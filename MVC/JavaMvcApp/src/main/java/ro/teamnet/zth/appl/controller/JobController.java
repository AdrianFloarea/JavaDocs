package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.domain.Job;
import ro.teamnet.zth.appl.service.JobService;
import ro.teamnet.zth.appl.service.JobServiceImpl;

import java.util.List;

/**
 * Created by user on 7/14/2016.
 */
@MyController(urlPath = "/jobs")
public class JobController {
    JobService jobService=new JobServiceImpl();

    @MyRequestMethod(urlPath = "/all")
    public List<Job> getAllJobs(){
        return jobService.findAllJobs();
    }

    @MyRequestMethod(urlPath ="/one")
    public String getOneJob(){
        return "oneRandomJob";
    }
}
