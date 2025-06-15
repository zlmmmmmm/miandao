package com.zlm.miandao.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlm.miandao.model.dto.questionBankQuestion.QuestionBankQuestionQueryRequest;
import com.zlm.miandao.model.entity.QuestionBankQuestion;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zlm.miandao.model.entity.User;
import com.zlm.miandao.model.vo.QuestionBankQuestionVO;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author admin
* @description 针对表【question_bank_question(题库题目)】的数据库操作Service
* @createDate 2025-06-06 18:50:37
*/
public interface QuestionBankQuestionService extends IService<QuestionBankQuestion> {
    /**
     * 校验数据
     *
     * @param questionBankQuestion
     * @param add 对创建的数据进行校验
     */
    void validQuestionBankQuestion(QuestionBankQuestion questionBankQuestion, boolean add);

    /**
     * 获取查询条件
     *
     * @param questionBankQuestionQueryRequest
     * @return
     */
    QueryWrapper<QuestionBankQuestion> getQueryWrapper(QuestionBankQuestionQueryRequest questionBankQuestionQueryRequest);

    /**
     * 获取题库题目关联封装
     *
     * @param questionBankQuestion
     * @param request
     * @return
     */
    QuestionBankQuestionVO getQuestionBankQuestionVO(QuestionBankQuestion questionBankQuestion, HttpServletRequest request);

    /**
     * 分页获取题库题目关联封装
     *
     * @param questionBankQuestionPage
     * @param request
     * @return
     */
    Page<QuestionBankQuestionVO> getQuestionBankQuestionVOPage(Page<QuestionBankQuestion> questionBankQuestionPage, HttpServletRequest request);


    void batchAddQuestionsToBank(List<Long> questionIdList, Long questionBankId, User loginUser);

    @Transactional(rollbackFor = Exception.class)
    void batchRemoveQuestionsFromBank(List<Long> questionIdList, Long questionBankId);

    @Transactional(rollbackFor = Exception.class)
    void batchAddQuestionsToBankInner(List<QuestionBankQuestion> questionBankQuestions);
}
