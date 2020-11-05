package com.xnj.hash;

/**
 * 假设有10亿个 URL 要加入黑名单
 *
 * 布隆过滤器： 准备 0-m-1 个比特数组（只能存放0和1）
 * 再准备k 个 hash函数，将 加入黑名单的URL 经过hash函数，再 将所得到的 数n % m ,即得到比特数组上的一个位置
 * 将该位置置为1，需经过 k 个hash函数
 *
 * 缺点： 错误型，当你URL 不是黑名单时，会误判是（另可错杀，也不放过）
 *
 * 当出现一个 URL 时，将它经过 这 k 个hash函数，并比较相应的位置，如果发现一个位置不为0，则表示不是黑名单内的URL
 *
 * m(数组的大小） = (n * ln ^p) / (ln ^ 2 ) ^ 2
 *       n : 样本量
 *       p 误差率
 *       注：向上取整
 *
 *  确定哈希函数的个数
 *      k = ln^2 * (m / n ) = 0.7 * (m / n)
 *      注：向上取整，eg: 12.5  -> 13
 *
 *  真实的误差率
 *      （1 - e ^ (- (n * k ) / m ) ) ^ k
 *
 *
 *
 * 一致性哈希技术
 *  用于服务器
 *  将数据的hash值看作一个环，每一个服务器（m-1, m-2, m-3) 都由路由表记录1000个虚拟节点在环上，顺时针找得到的节点用实际的服务器来处理
 *  保证了环是均匀分布的，当你增加服务器或减少服务器时，也同时增加（减少）虚拟节点在环上，以保证均匀分布
 *
 * @author chen xuanyi
 * @Date 2020/5/10 22:06
 */
public class BuLongSpilte {
    //index : 需要过滤的数，将它所对应的地方的bit 值为1
    public static void buLong(int index){//eg:30000
        int[] arr = new int[1000];//一个 int 相当于4 byte， 相当于 32 bit 所以有 32000 bit

        //因为一个字节表示有32 bit , 给定的index 为 bit,所以应该定位到哪个字节
        int intIndex = index / 32;//对应哪个字节

        int bitIndex = index % 32;//对应字节的哪个位

        arr[intIndex] = (arr[intIndex] | (1 << bitIndex));
    }

}
