package sap;

public class Problem1 {

	public static void main(String[] args) {

	}

}

class JobDTO{

	private String JobName;
	private String JobType;
	private int jobPriority;

	public JobDTO(String jobName, String jobType, int jobPriority) {
		super();
		JobName = jobName;
		JobType = jobType;
		this.jobPriority = jobPriority;
	}

	public String getJobName() {
		return JobName;
	}
	public void setJobName(String jobName) {
		JobName = jobName;
	}
	public String getJobType() {
		return JobType;
	}
	public void setJobType(String jobType) {
		JobType = jobType;
	}
	public int getJobPriority() {
		return jobPriority;
	}
	public void setJobPriority(int jobPriority) {
		this.jobPriority = jobPriority;
	}

}
