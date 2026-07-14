public class Task1{
    private int v;
    public int getNext(){
        return v++;
    }
}

public class Task2 implements Servlet{
    private long count = 0;
    public long getCount(){return count;}
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[ ] factors = factor(i);
        ++count;
        encodeIntoResponse(resp, factors);
    }
}

public class Task3 implements Servlet{
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[ ] factors = factor(i);
        encodeIntoResponse(resp, factors);
    }
    
}

// Thread safe version of the codes above

// 1 - Using AtomicInteger for lock-free atomic increment
import java.util.concurrent.atomic.AtomicInteger;
public class Task1Safe{
    private AtomicInteger v = new AtomicInteger();
    public int getNext(){
        return v.getAndIncrement(); // atomically returns current value then increments
    }
}

// 2 - Using AtomicLong to fix the non-atomic ++count and visibility issues
import java.util.concurrent.atomic.AtomicLong;
public class Task2Safe implements Servlet{
    private final AtomicLong count = new AtomicLong(0);
    public long getCount(){return count.get();} // atomic read with visibility guarantee
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[ ] factors = factor(i);
        count.incrementAndGet(); // atomic increment, replaces the non-atomic ++count
        encodeIntoResponse(resp, factors);
    }
}

// 3 - Already thread safe (stateless: no shared mutable fields, all variables are local)
public class Task3Safe implements Servlet{
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[ ] factors = factor(i);
        encodeIntoResponse(resp, factors);
    }
}