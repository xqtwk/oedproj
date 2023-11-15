package factory;

public class PremiumMemberFactory extends MemberFactory {
    @Override
    public Member createMember() {
        return new PremiumMember();
    }
}
