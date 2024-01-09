package ie.atu.project.cicd_project.RankingMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rankings")
public class RankingController {

    private final RankingService rankingService;

    @Autowired
    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @GetMapping
    public List<Ranking> getAllRankings() {
        return rankingService.findAllRankings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ranking> getRankingById(@PathVariable Long id) {
        return rankingService.findRankingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ranking createRanking(@RequestBody Ranking ranking) {
        return rankingService.saveRanking(ranking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ranking> updateRanking(@PathVariable Long id, @RequestBody Ranking rankingDetails) {
        return rankingService.updateRanking(id, rankingDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRanking(@PathVariable Long id) {
        if (rankingService.deleteRanking(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
