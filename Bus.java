@Entity
public class Bus {
    @Id @GeneratedValue
    private Long id;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private double price;
}
