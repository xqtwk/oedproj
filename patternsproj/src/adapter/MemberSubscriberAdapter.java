package adapter;

import factory.Member;
import observer.Subscriber;

public class MemberSubscriberAdapter implements Subscriber {
    private Member member;

    public MemberSubscriberAdapter(Member member) {
        this.member = member;
    }

    @Override
    public void update(String string) {
        member.receiveNotification(string);
    }
}
