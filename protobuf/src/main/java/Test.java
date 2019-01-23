import com.ekfet.protobuf.model.PersonProtos;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author radish.zhou
 * @version v 1.0
 * @ClassName: Test
 * @date 2019/1/23 10:39
 */
public class Test {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        PersonProtos.Person.Builder builder= PersonProtos.Person.newBuilder();
        builder.setEmail("lxfeif123@126.com");
        builder.setId(100);
        builder.setName("join");

        PersonProtos.Person person=builder.build();

        byte[] data=person.toByteArray();
        PersonProtos.Person person1=PersonProtos.Person.parseFrom(data);
        System.out.println(person.getEmail());
        System.out.println(person1.getEmail());

    }
}
