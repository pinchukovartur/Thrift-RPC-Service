import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import thriftservice.ThriftHandler;
import thriftservice.ThriftService;

public class Server {

    private void start(){
        try {
            // Set port
            TServerSocket serverTransport = new TServerSocket(7911);
            // Set CrawlingHandler we defined before
            // to processor, which handles RPC calls
            // Remember, one service per server
            ThriftHandler handler = new ThriftHandler();
            ThriftService.Processor<ThriftService.Iface> processor
                    = new ThriftService.Processor<ThriftService.Iface>(handler);

            TServer server = new TThreadPoolServer(
                    new TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println("Starting server on port 7911 ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        Server server = new Server();
        server.start();
    }

}