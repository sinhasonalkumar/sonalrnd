package com.sonal.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StMain {

    public static void main(String[] args) {
	
	List<String> names = Arrays.asList("a","b","c","d");
	
	List<ResponseVO> collect = names.stream().filter(n -> customFilter(n))
		       .map(n -> buildResult(n))
		       .map(r -> convert(r))
		       .collect(Collectors.toList());
	
    }
    
    private static boolean customFilter(String s) {
	return true;
    }
    
    private static ResultVO buildResult(String s) {
	ResultVO resultVO = new ResultVO();
	resultVO.setResult("Passed : " + s);
	return resultVO;
    }
    
    private static ResponseVO convert(ResultVO resultVO) {
	ResponseVO responseVO = new ResponseVO();
	responseVO.setResult(responseVO.getResult());
	return responseVO;
    }
}
