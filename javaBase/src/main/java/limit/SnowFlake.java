package limit;//package www.zy.test.limit;
//
///**
// * @author zhangyan
// * @version 1.0
// * @date 2022/4/11 5:11 PM
// */
//public class SnowFlake {
//
//
//    /**
//     * 每一部分占用的位数
//     */
//    // 序列号占用的位数
//    private static final long SEQUENCE_BIT = 12;
//    // 机器标识占用的位数 32
//    private static final long MACHINE_BIT = 5;
//
//    /**
//     * 每一部分的最大值
//     */
//    private static final long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
//    private static final long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);
//
//    /**
//     * 每一部分向左的位移
//     */
//    private static final long MACHINE_LEFT = SEQUENCE_BIT;
//    private static final long TIMESTMP_LEFT = SEQUENCE_BIT + MACHINE_BIT;
//
//    private long machineId; // 机器标识
//    private long sequence = 0L; // 序列号
//    private long lastStmp = -1L;// 上一次时间戳
//
//
//    /**
//     * 产生下一个ID
//     *
//     * @return
//     */
//    public synchronized long nextId() {
//        long currStmp = getNewstmp();
//        if (currStmp < lastStmp) {
//            throw new Exception("Clock moved backwards.  Refusing to generate id");
//        }
//
//        if (currStmp == lastStmp) {
//            // 相同毫秒内，序列号自增
//            sequence = (sequence + 1) & MAX_SEQUENCE;
//            // 同一毫秒的序列数已经达到最大
//            if (sequence == 0L) {
//                currStmp = getNextMill();
//            }
//        } else {
//            // 不同毫秒内，序列号置为0
//            sequence = 0L;
//        }
//
//        lastStmp = currStmp;
//
//        return (currStmp - START_STMP) << TIMESTMP_LEFT // 时间戳部分
//                | machineId << MACHINE_LEFT // 机器标识部分
//                | sequence; // 序列号部分
//    }
//
//    private long getNextMill() {
//        long mill = getNewstmp();
//        while (mill <= lastStmp) {
//            mill = getNewstmp();
//        }
//        return mill;
//    }
//
//    public void setSequence(long sequence) {
//        this.sequence = sequence;
//    }
////
//    public void setLastStmp(long lastStmp) {
//        this.lastStmp = lastStmp;
//    }
//
//    private long getNewstmp() {
//        return System.currentTimeMillis();
//    }
//}
