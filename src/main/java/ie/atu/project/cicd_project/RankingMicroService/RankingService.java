package ie.atu.project.cicd_project.RankingMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RankingService {
    private final RankingRepo rankingRepo;

    @Autowired
    public RankingService(RankingRepo rankingRepo) {
        this.rankingRepo = rankingRepo;
    }

    public List<Ranking> findAllRankings() {
        return rankingRepo.findAll();
    }

    public Optional<Ranking> findRankingById(Long id) {
        return rankingRepo.findById(id);
    }

    public Ranking saveRanking(Ranking ranking) {
        return rankingRepo.save(ranking);
    }

    public Optional<Ranking> updateRanking(Long id, Ranking rankingDetails) {
        return rankingRepo.findById(id)
                .map(existingRanking -> {
                    existingRanking.setMemberId(rankingDetails.getMemberId());
                    existingRanking.setBeltRank(rankingDetails.getBeltRank());
                    existingRanking.setPoints(rankingDetails.getPoints());
                    return rankingRepo.save(existingRanking);
                });
    }

    public boolean deleteRanking(Long id) {
        return rankingRepo.findById(id)
                .map(ranking -> {
                    rankingRepo.delete(ranking);
                    return true;
                }).orElse(false);
    }
}
