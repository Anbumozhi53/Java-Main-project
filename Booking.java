@Entity
public class Booking {
    @Id @GeneratedValue
    private Long id;
    private Long userId;
    private Long busId;
    private String seatNumber;
    private LocalDate date;
}
