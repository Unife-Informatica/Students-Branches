public class Clock {
    Counter[] clock;
    int max_sec = 60, max_min = 60, max_hours = 24;

    public Clock() {
        clock = new Counter[]{new Counter(0), new Counter(0), new Counter(0)};
        runClock();
    }

    private void runClock() {
        for (int i = 0; i < max_hours; i++) {
            for (int j = 0; j < max_min; j++) {
                for (int k = 0; k < max_sec; k++) {
                    clock[2].inc(); // seconds
                }
                clock[1].inc(); // minutes
            }
            clock[0].inc(); // hours
        }
    }
}
