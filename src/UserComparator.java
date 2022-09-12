import java.util.Comparator;

public class UserComparator implements Comparator<AbstractUserEntity> {

    @Override
    public int compare(AbstractUserEntity o1, AbstractUserEntity o2) {
        final Role o1Role = o1.getRole();
        final Role o2Role = o2.getRole();

        if (o1Role.compareTo(o2Role) < 0 ) {
            return 1;
        } else if (o1Role.compareTo(o2Role) > 0 ) {
            return -1;
        }
        return 0;
    }
}
