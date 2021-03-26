package newProcessing;

import Controller.Date;
import Payment.Payment;

class Job {
    private Date urgency;
    private int customerId;
    private boolean confirmedStatus, completedStatus, paid;
    private int jobId;
    private TaskCollection taskCollection;
    private Payment payment;
    TaskTypeCollection taskTypeCollection;

    public Date getUrgency() {
        return urgency;
    }

    public void setUrgency(Date urgency) {
        this.urgency = urgency;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isConfirmedStatus() {
        return confirmedStatus;
    }

    public void setConfirmedStatus(boolean confirmedStatus) {
        this.confirmedStatus = confirmedStatus;
    }

    public boolean isCompletedStatus() {
        return completedStatus;
    }

    public void setCompletedStatus(boolean completedStatus) {
        this.completedStatus = completedStatus;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public TaskCollection getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(TaskCollection taskCollection) {
        taskCollection = new TaskCollection();
        for (Task task : taskCollection.tasks) {
            // gui to add the task to the job
            taskCollection.addTask(task);
        }

    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
