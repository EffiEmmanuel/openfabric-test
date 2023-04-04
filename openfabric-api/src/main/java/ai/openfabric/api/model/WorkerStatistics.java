package ai.openfabric.api.model;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Statistics;
import com.github.dockerjava.core.DockerClientBuilder;

public class WorkerStatistics {
    private DockerClient dockerClient;

    public WorkerStatistics(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    //  This method returns the statistics for a particular worker
    public Statistics getWorkerStatistics(String workerId) {
        // Creating a new docker client instance to enable communication with docker
        DockerClient dockerClient = DockerClientBuilder.getInstance().build();

        // Creating a new WorkerStatistics instance with the dockerClient
        WorkerStatistics workerStatistics = new WorkerStatistics(dockerClient);

        // Getting the statistics for the workerId provided
        return workerStatistics.getWorkerStatistics(workerId);
    }
}
