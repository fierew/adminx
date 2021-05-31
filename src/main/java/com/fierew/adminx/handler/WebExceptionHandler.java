package com.fierew.adminx.handler;

import com.fierew.adminx.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 * @author xuyang
 */
@Slf4j
@RestControllerAdvice
public class WebExceptionHandler {
    /**
     * 一般的参数绑定时候抛出的异常
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVO handleBindException(BindException ex) {
        log.error("参数校验异常", ex);
        List<String> defaultMsg = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return ResultVO.error(400, defaultMsg.get(0));
    }

    /**
     * 单个参数校验
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVO handleBindGetException(ConstraintViolationException ex) {
        log.error("单个参数校验异常", ex);
        List<String> defaultMsg = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return ResultVO.error(400, defaultMsg.get(0));
    }

    /**
     * 参数校验错误
     */
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVO handleValidationException(ValidationException ex) {
        log.error("参数校验错误：{}", ex.getMessage(), ex);
        return ResultVO.error(400, ex.getCause().getMessage());
    }

    /**
     * 字段校验不通过异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVO handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("字段校验不通过异常：{}", ex.getMessage(), ex);
        StringJoiner sj = new StringJoiner(";");
        ex.getBindingResult().getFieldErrors().forEach(x -> sj.add(x.getDefaultMessage()));
        return ResultVO.error(400, sj.toString());
    }

    /**
     * Controller参数绑定错误
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        log.error("Controller参数绑定错误：{}", ex.getMessage(), ex);
        return ResultVO.error(500, ex.getMessage());
    }

    /**
     * 处理方法不支持异常
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResultVO handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        log.error("处理方法不支持异常：{}", ex.getMessage(), ex);
        return ResultVO.error(404, "找不到处理方法");
    }

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO runtimeExceptionHandler(RuntimeException ex) {
        log.error("运行时异常：{}", ex.getMessage(), ex);
        return ResultVO.error(500, "运行时异常");
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO nullPointerExceptionHandler(NullPointerException ex) {
        log.error("空指针异常：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "空指针异常");
    }

    /**
     * 类型转换异常
     */
    @ExceptionHandler(ClassCastException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO classCastExceptionHandler(ClassCastException ex) {
        log.error("类型转换异常：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "类型转换异常");
    }

    /**
     * 文件未找到异常
     */
    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO fileNotFoundException(FileNotFoundException ex) {
        log.error("文件未找到异常：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "文件未找到异常");
    }

    /**
     * 数字格式异常
     */
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO numberFormatException(NumberFormatException ex) {
        log.error("数字格式异常：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "数字格式异常");
    }

    /**
     * 安全异常
     */
    @ExceptionHandler(SecurityException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO securityException(SecurityException ex) {
        log.error("安全异常：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "安全异常");
    }

    /**
     * sql异常
     */
    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO sqlException(SQLException ex) {
        log.error("sql异常：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "sql异常");
    }

    /**
     * 类型不存在异常
     */
    @ExceptionHandler(TypeNotPresentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO typeNotPresentException(TypeNotPresentException ex) {
        log.error("类型不存在异常：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "类型不存在异常");
    }

    /**
     * IO异常
     */
    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO ioExceptionHandler(IOException ex) {
        log.error("IO异常：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "IO异常");
    }

    /**
     * 未知方法异常
     */
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        log.error("未知方法异常：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "未知方法异常");
    }

    /**
     * 数组越界异常
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        log.error("数组越界异常：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "数组越界异常");
    }

    /**
     * sql语法错误异常
     */
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO badSqlGrammarException(BadSqlGrammarException ex) {
        log.error("sql语法错误异常：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "sql语法错误异常");
    }

    /**
     * 无法注入bean异常
     */
    @ExceptionHandler(NoSuchBeanDefinitionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO noSuchBeanDefinitionException(NoSuchBeanDefinitionException ex) {
        log.error("无法注入bean异常 ：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "无法注入bean");
    }

    /**
     * Http消息不可读异常
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO requestNotReadable(HttpMessageNotReadableException ex) {
        log.error("400错误..requestNotReadable：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "Http消息不可读");
    }

    /**
     * 400错误
     */
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO requestTypeMismatch(TypeMismatchException ex) {
        log.error("400错误..TypeMismatchException：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "服务器异常");
    }

    /**
     * 500错误
     */
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO server500(RuntimeException ex) {
        log.error("500错误：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "服务器异常");
    }

    /**
     * 栈溢出
     */
    @ExceptionHandler({StackOverflowError.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO requestStackOverflow(StackOverflowError ex) {
        log.error("栈溢出：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "栈溢出异常");
    }

    /**
     * 除数不能为0
     */
    @ExceptionHandler({ArithmeticException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO arithmeticException(ArithmeticException ex) {
        log.error("除数不能为0：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "除数不能为0异常");
    }

    /**
     * 其他错误
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO exception(Exception ex) {
        log.error("其他错误：{} ", ex.getMessage(), ex);
        return ResultVO.error(500, "网络连接失败，请退出后再试");
    }
}
