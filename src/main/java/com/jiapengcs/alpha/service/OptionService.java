package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.model.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface OptionService {

    Option saveOption(Option option);

    void deleteOption(Long oid);

    Option updateOption(Option option);

    Option getOption(Long oid);

    List<Option> listAllOptions();

    Page<Option> listAllOptionsByPage(Pageable pageable);
}
