package com.hy.ioms.model;

/**
 * 转换 用于dto转换为vo
 * <p>
 * exp: DTO implements Mapper<VO>
 *
 * @param <T>
 */
public interface Mapper<T> {
    T transform();
}
