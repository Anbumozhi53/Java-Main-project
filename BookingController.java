@Controller
public class BookingController {
    @Autowired BookingRepository bookingRepo;

    @PostMapping("/book")
    public String book(@RequestParam Long busId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Booking booking = new Booking();
        booking.setBusId(busId);
        booking.setUserId(user.getId());
        booking.setDate(LocalDate.now());
        booking.setSeatNumber("A1"); // Simple example
        bookingRepo.save(booking);
        return "redirect:/my-bookings";
    }

    @GetMapping("/my-bookings")
    public String viewBookings(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Booking> bookings = bookingRepo.findByUserId(user.getId());
        model.addAttribute("bookings", bookings);
        return "booking-history";
    }
}
