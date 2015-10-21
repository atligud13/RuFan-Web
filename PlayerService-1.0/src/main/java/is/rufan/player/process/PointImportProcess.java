package is.rufan.player.process;

import is.rufan.player.domain.Point;
import is.rufan.player.service.PointService;
import is.rufan.player.service.PointServiceException;
import is.ruframework.process.RuAbstractProcess;
import is.ruframework.reader.RuReadHandler;
import is.ruframework.reader.RuReader;
import is.ruframework.reader.RuReaderException;
import is.ruframework.reader.RuReaderFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.logging.Logger;

/**
 * Created by Atli Guðlaugsson on 10/21/2015.
 */
public class PointImportProcess extends RuAbstractProcess implements RuReadHandler
{
    private PointService pointService;
    MessageSource msg;
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void beforeProcess()
    {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:pointapp.xml");
        pointService = (PointService) applicationContext.getBean("pointService");
        msg = (MessageSource) applicationContext.getBean("messageSource");
        logger.info("processbefore: " + getProcessContext().getProcessName());
    }

    @Override
    public void startProcess()
    {
        RuReaderFactory factory = new RuReaderFactory("pointprocess.xml");
        RuReader reader = factory.getReader("pointReader");

        reader.setReadHandler(this);
        try
        {
            reader.read();
        }
        catch (RuReaderException e)
        {
            String errorMsg = "Unable to read specified file.";
            logger.severe(errorMsg);
        }
    }

    public void read(int count, Object object)
    {
        Point point = (Point) object;
        try
        {
            pointService.addPoint(point);
        }
        catch(PointServiceException se)
        {
            logger.warning("Point for player" + point.getPlayerId() + " not added " + se.getMessage());
        }
    }
}
