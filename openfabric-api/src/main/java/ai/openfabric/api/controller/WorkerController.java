package ai.openfabric.api.controller;

import ai.openfabric.api.service.WorkerService;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${node.api.path}/worker")
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping(path = "/hello")
    public @ResponseBody String hello(@RequestBody String name) {
        return "Hello!" + name;
    }

    //  This route returns all workers from the database
    @GetMapping(path = "/fetch-all-workers")
    public List<Container> fetchWorkers () {
        return workerService.fetchAllWorkers();
    }

    // This route returns the details for a specific worker
    @GetMapping(path = "/get-worker-details")
    public InspectContainerResponse fetchWorkerDetails(@RequestParam String workerId) {
        return workerService.fetchWorkerDetails(workerId);
    }

    // This route starts a worker
    @PostMapping(path = "/start-worker")
    public String startWorker (@RequestParam String workerId) {
        return workerService.startWorker(workerId);
    }

    // This route stops a worker
    @PatchMapping(path = "/stop-worker")
    public String stopWorker (@RequestParam String workerId) {
        return workerService.stopWorker(workerId);
    }
}
