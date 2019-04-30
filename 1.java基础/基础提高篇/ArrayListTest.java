/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.list;

import java.util.Arrays;
import java.util.Collection;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年2月19日
 * @author chengq
 */
public class ArrayListTest<E> {

    /** List默认长度 10 **/
    private static final Integer DEFAULT_SIZE = 10;

    /** 初始化默认数组 空数组 **/
    private static final Object[] DEFAULT_EMPTY_ELEMENTDATA = {};

    /** 每次修改时加1，用于记录修改次数 **/
    private transient int modCount = 0;

    /** int类型最大值 2的32次方-1 2147483639 **/
    private static final int MAX_ARRAY_SIZE = 2147483639;

    /**
     * elementData ArrayList中数组,存放list中数值
     *
     * transient修饰符-被修饰的成员属性变量不被序列化
     */
    transient Object[] elementData;

    /**
     * ArrayList长度
     */
    private int size;

    /**
     * 三种初始化方法
     */

    /**
     * 无参初始化
     */
    public ArrayListTest() {
        this.elementData = DEFAULT_EMPTY_ELEMENTDATA;
    }

    /**
     * 初始化列表长度
     *
     * @param initialCapacity
     *            列表长度
     */
    public ArrayListTest(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = DEFAULT_EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("传错值啦");
        }
    }

    /**
     * 初始化列表数据
     *
     * @param c
     *            插入数据
     */
    public ArrayListTest(Collection<? extends E> c) {
        this.elementData = c.toArray();
        // c.toArray()方法可能会出现问题
        if ((size = elementData.length) != 0) {
            // 如果插入的数据类型不是Object类型，就通过Arrays.copyOf方法 生成一个新的Object对象数组赋值给elementData。
            if (elementData.getClass() != Object[].class) {
                elementData = Arrays.copyOf(elementData, size, Object[].class);
            }
        } else {
            this.elementData = DEFAULT_EMPTY_ELEMENTDATA;
        }
    }

    /**
     * 新增一个对象
     *
     * @param e
     *            对象
     * @return
     */
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    /**
     * 在指定位置插入对象
     *
     * @param element
     *            对象
     * @param index
     *            位置
     * @return true/false
     */
    public void add(int index, E element) {
        indexCheck(index);
        ensureCapacityInternal(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    /**
     * 新增对象集合
     *
     * @param c
     *            对象集合
     * @return
     */
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int num = a.length;
        ensureCapacityInternal(size + num);
        System.arraycopy(a, 0, elementData, size, num);
        size += num;
        return true;
    }

    /**
     * 新增对象集合
     *
     * @param c
     *            对象集合
     * @return
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        indexCheck(index);
        Object[] a = c.toArray();
        int num = a.length;
        ensureCapacityInternal(size + num);
        int movesize = size - index;
        System.arraycopy(elementData, index, elementData, index + num, movesize);
        System.arraycopy(a, 0, elementData, index, num);
        size += num;
        return true;
    }

    /**
     * 列表删除 开始
     */

    /**
     * 删除指定位置的数据
     *
     * @param index
     *            指定的数据位置
     * @return E 删除元素
     */
    public E remove(int index) {
        indexCheck(index);
        E oldObject = elementData(index);
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[--size] = null;
        return oldObject;
    }

    /**
     * 删除指定元素的数据，多个相同数据，只删除第一个
     *
     * @param o
     *            指定的元素
     * @return true/false
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除数组中包含有列表中元素的数据
     *
     * @param c
     *            列表
     * @param complement
     *            true删除非列表中元素，false删除列表中元素
     * @return true/false
     */
    public boolean removeAll(Collection<? extends E> c) {
        removeBatch(c, false);
        return true;
    }

    /**
     * 删除数组中包含有列表中元素的数据
     *
     * @param c
     *            列表
     * @param complement
     *            true删除非列表中元素，false删除列表中元素
     * @return true/false
     */
    public boolean removeBatch(Collection<? extends E> c, boolean complement) {
        final Object[] elementData = this.elementData;
        int r = 0, w = 0;
        boolean modified = false;
        try {
            for (; r < size; r++)
                if (c.contains(elementData[r]) == complement)
                    elementData[w++] = elementData[r];
        } finally {
            if (r != size) {
                System.arraycopy(elementData, r, elementData, w, size - r);
                w += size - r;
            }
            if (w != size) {
                for (int i = w; i < size; i++)
                    elementData[i] = null;
                modCount += size - w;
                size = w;
                modified = true;
            }
        }
        return modified;
    }

    /**
     * 列表删除 结束
     */

    /**
     * 列表修改 开始
     */
    public E set(int index, E e) {
        indexCheck(index);
        E oldObject = elementData(index);
        elementData[index] = e;
        return oldObject;
    }

    /**
     * 列表修改 结束
     */

    /**
     * 列表查询 开始
     */

    /**
     * 查询指定位置的元素
     *
     * @param index
     *            位置
     * @return 元素
     */
    public E get(int index) {
        indexCheck(index);
        return elementData(index);
    }

    /**
     * 快速删除指定位置的数据,在根据对象删除元素中使用
     *
     * @param index
     *            指定的数据位置
     */
    public void fastRemove(int index) {
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[--size] = null;
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    public boolean indexCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("index = " + index + ", size = " + size);
        }
        return true;
    }

    /**
     * 确定长度大小
     *
     * @param minCapacity
     *            最小长度
     */
    public void ensureCapacityInternal(int minCapacity) {
        calculateCapacity(elementData, minCapacity);
    }

    /**
     * 如果数组为空，默认数组长度为10
     *
     * @return 数组长度
     */
    public int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULT_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_SIZE, minCapacity);
        }
        return minCapacity;
    }

    /**
     * 确定最终数组长度
     *
     * @param minCapacity
     *            添加数据后数组长度
     */
    public void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        // 如果添加数据后数组长度大于现在数据长度 扩容
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    /**
     * 当插入数据个数超过数组长度时扩容
     *
     * @param minCapacity
     *            需要的长度
     */
    public void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + oldCapacity >> 1;
        // 扩容1.5倍后，长度还是比不上添加数据后个数，则长度变为添加数据后个数
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        // 如果新生成的数组长度超过int类型的最大值,设定数组长度为最大值
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
        }
        // 将原来数组内容复制到新长度的数组
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }
}
