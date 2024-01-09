package ie.atu.project.cicd_project.MemeberMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepo memberRepo;

    @Autowired
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public List<Member> findAllMembers() {
        return memberRepo.findAll();
    }

    public Optional<Member> findMemberById(Long id) {
        return memberRepo.findById(id);
    }

    public Member saveMember(Member member) {
        return memberRepo.save(member);
    }

    public Optional<Member> updateMember(Long id, Member memberDetails) {
        return memberRepo.findById(id)
                .map(existingMember -> {
                    updateExistingMember(existingMember, memberDetails);
                    return memberRepo.save(existingMember);
                });
    }

    public boolean deleteMember(Long id) {
        return memberRepo.findById(id)
                .map(member -> {
                    memberRepo.delete(member);
                    return true;
                }).orElse(false);
    }

    private void updateExistingMember(Member existingMember, Member memberDetails) {
        existingMember.setName(memberDetails.getName());
        existingMember.setBeltRank(memberDetails.getBeltRank());
        existingMember.setActive(memberDetails.isActive());
    }
}
