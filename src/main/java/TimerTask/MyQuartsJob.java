package TimerTask;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @classDesc： 功能描述：（）
 * @author：王武
 * @createTime 2018/1/21
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class MyQuartsJob implements Job{
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("执行日期"+new Date().getTime());
    }
}
