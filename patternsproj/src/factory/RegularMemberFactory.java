package factory;

public class RegularMemberFactory extends MemberFactory {
    @Override
    public Member createMember() {
        return new RegularMember();
    }
}
