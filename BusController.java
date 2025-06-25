@Controller
public class BusController {
    @Autowired BusRepository busRepo;

    @GetMapping("/search")
    public String searchForm() { return "search"; }

    @PostMapping("/search")
    public String searchBuses(@RequestParam String source, @RequestParam String destination, Model model) {
        List<Bus> buses = busRepo.findBySourceAndDestination(source, destination);
        model.addAttribute("buses", buses);
        return "bus-list";
    }
}
