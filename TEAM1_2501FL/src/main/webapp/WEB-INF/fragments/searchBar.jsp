<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="inner">
	
	<!-- 직업 / 지역 선택에 따라 유동적으로 href / text 값 유동적으로 띄워주기 -->
	<ul class="TabBox tab_jobs_area">
	    <li class="Select"><a class="BtnType" href="javascript:void(0)"><span>직업</span></a></li>
	    <li class=""><a class="BtnType" href="javascript:void(0)"><span>산업</span></a></li>
	</ul>
	<!-- // end 직업 / 지역 선택에 따라 유동적으로 href / text 값 유동적으로 띄워주기 -->
	
	
	<div id="search_panel_wrapper" class="recruit_search_panel">
	    <form id="search_panel_form" name="search_panel_form">
	        <fieldset>
	            <div id="sp_main_wrapper" class="wrap_main_panel" data-default="domestic">
	            	
	            	<!-- default_option 영역 / 경력, 학력, 메일관리 -->
	                <div class="default_option">
	                
	                    <!-- 경력선택 버튼 + 팝업 -->
	                    <div class="search_option career_option">
	                        <button type="button" class="btn_open_layer">경력 선택</button>
	                        <div class="layer_option">
	                            <strong class="tit">경력 전체</strong>
	                            <div class="area_check">
	                                <div class="inpChk small">
	                                    <input type="checkbox" data-group="career" data-key="exp_cd" data-value="1" id="zero_experience">
	                                    <label for="zero_experience" class="lbl">신입</label>
	                                </div>
	                                <div class="inpChk small experience">
	                                    <input type="checkbox" data-group="career" data-key="exp_cd" data-value="2" id="experience">
	                                    <label for="experience" class="lbl">경력</label>
	                                </div>
	                                <div class="inpChk small right">
	                                    <input type="checkbox" data-group="career" data-key="exp_none" data-value="y" id="no_experience">
	                                    <label for="no_experience" class="lbl">경력무관</label>
	                                </div>
	                            </div>
	                            <div class="area_detail_select">
	                                <strong class="blind">경력 상세 선택하기</strong>
	                                <ul class="btns" data-key="career">
	                                    <li>
	                                        <span class="btn_check ">
	                                            <input type="checkbox" id="btn_check_career_over0" data-index="0" name="check_career" title="~1년" value="">
	                                            <label for="btn_check_career_over0">~1년</label>
	                                        </span>
	                                    </li>
	                                    <li>
	                                        <span class="btn_check ">
	                                            <input type="checkbox" id="btn_check_career_over1" data-index="1" name="check_career" title="1년" value="">
	                                            <label for="btn_check_career_over1">1년</label>
	                                        </span>
	                                    </li>
	                                    <li>
	                                        <span class="btn_check ">
	                                            <input type="checkbox" id="btn_check_career_over2" data-index="2" name="check_career" title="2년" value="">
	                                            <label for="btn_check_career_over2">2년</label>
	                                        </span>
	                                    </li>
	                                    <li>
	                                        <span class="btn_check ">
	                                            <input type="checkbox" id="btn_check_career_over3" data-index="3" name="check_career" title="3년" value="">
	                                            <label for="btn_check_career_over3">3년</label>
	                                        </span>
	                                    </li>
	                                    <li>
	                                        <span class="btn_check ">
	                                            <input type="checkbox" id="btn_check_career_over4" data-index="4" name="check_career" title="4년" value="">
	                                            <label for="btn_check_career_over4">4년</label>
	                                        </span>
	                                    </li>
	                                    <!-- 
	                                    	↓ 한줄에 들어가는 칸의 개수가 5개 보다 적을때 빈칸만큼 아래 코드 추가해주세요.
	                                    	ex) 5칸중 3칸은 경력 데이터 있음, 아래코드 2줄 추가 
	                                    	<li class="blank"></li>
	                                    -->
	                                </ul>
	                            </div>
	                            <!-- dummy layer -->
	                            <div class="area_btn">
	                                <button type="button" data-clear="exp" class="btn_basic_type02 btn_reset">선택 초기화</button>
	                                <button type="button" class="closeDefaultOptionLayer btn_basic_type02 btn_close">닫기</button>
	                            </div>
	                            <!-- // -->
	                        </div>
	                    </div>	                    
	                    <!-- // end 경력선택 버튼 + 팝업 -->
	                    
	                    
	                    <!-- 학력선택 버튼 + 팝업 -->
	                    <div class="search_option edu_option">
	                        <button type="button" class="btn_open_layer">학력 선택</button>
	                        <div class="layer_option">
	                            <strong class="tit">학력 전체</strong>
	                            <div class="area_check">
	                                <div class="inpChk small right">
	                                    <input type="checkbox" data-group="career" data-key="edu_none" data-value="y" id="no_education">
	                                    <label for="no_education" class="lbl">학력무관</label>
	                                </div>
	                            </div>
	
	                            <div class="area_detail_select">
	                                <strong class="blind">상세 선택하기</strong>
	                                <ul class="btns" data-key="education">
	                                    <li>
	                                        <span class="btn_check ">
	                                            <input type="checkbox" id="btn_check_edu_0" data-index="0" name="check_edu" title="고교 졸업 이하" value="">
	                                            <label for="btn_check_edu_0">고교 졸업<br>이하</label>
	                                        </span>
	                                    </li>
	                                    <li>
	                                        <span class="btn_check ">
	                                            <input type="checkbox" id="btn_check_edu_1" data-index="1" name="check_edu" title="고등학교 졸업" value="">
	                                            <label for="btn_check_edu_1">고등학교<br>졸업</label>
	                                        </span>
	                                    </li>
	                                    <li>
	                                        <span class="btn_check ">
	                                            <input type="checkbox" id="btn_check_edu_2" data-index="2" name="check_edu" title="대학 졸업 (2,3년제)" value="">
	                                            <label for="btn_check_edu_2">대학 졸업<br>(2,3년제)</label>
	                                        </span>
	                                    </li>
	                                    <li>
	                                        <span class="btn_check ">
	                                            <input type="checkbox" id="btn_check_edu_3" data-index="3" name="check_edu" title="대학교 졸업 (4년제)" value="">
	                                            <label for="btn_check_edu_3">대학교 졸업<br>(4년제)</label>
	                                        </span>
	                                    </li>
	                                    <li>
	                                        <span class="btn_check ">
	                                            <input type="checkbox" id="btn_check_edu_4" data-index="4" name="check_edu" title="대학원 석사 졸업" value="">
	                                            <label for="btn_check_edu_4">대학원 석사<br>졸업</label>
	                                        </span>
	                                    </li>
	                                    <li>
	                                        <span class="btn_check ">
	                                            <input type="checkbox" id="btn_check_edu_5" data-index="5" name="check_edu" title="대학원 박사 졸업" value="">
	                                            <label for="btn_check_edu_5">대학원 박사<br>졸업</label>
	                                        </span>
	                                    </li>
	                                    <li>
	                                        <span class="btn_check ">
	                                            <input type="checkbox" id="btn_check_edu_6" data-index="6" name="check_edu" title="박사 졸업 이상" value="">
	                                            <label for="btn_check_edu_6">박사 졸업<br>이상</label>
	                                        </span>
	                                    </li>
	                                    <li class="blank"></li>
	                                </ul>
	                            </div>
	                            <!-- dummy layer -->
	                            <div class="area_btn">
	                                <button type="button" class="btn_basic_type02 btn_reset" data-clear="edu">선택 초기화</button>
	                                <button type="button" class="closeDefaultOptionLayer btn_basic_type02 btn_close">닫기</button>
	                            </div>
	                            <!-- // -->
	                        </div>
	                    </div>
	                    <!-- // end 학력선택 버튼 + 팝업 -->
	                	
	                </div>	                
	                <!-- // end default_option 영역 / 경력, 학력, 메일관리 -->
	                
	                
	                
	                <div class="main_option ">
	                    <ul class="tab_section">
	                        <li class="area_section">
	                            <button type="button" class="btn_area btn_open_layer ">
	                                <span class="input_placeholder">지역 선택</span>
	                                <span class="input_text"></span>
	                            </button>
	                        </li>
	                        <li class="job_category_section">
	                            <button type="button" class="btn_job_category btn_open_layer ">
	                                <span class="input_placeholder">직업 선택</span>
	                                <span class="input_text"></span>
	                            </button>
	                        </li>
	                        <li class="keyword_section">
	                            <button type="button" class="btn_keyword btn_open_layer keyword">
	                                <span class="input_placeholder">검색어 입력</span>
	                                <span class="input_text"></span>
	                            </button>
	                        </li>
	                        <li class="detail_section"><button type="button" class="btn_detail_option"><span>상세조건</span></button></li>
	                    </ul>
	                    <div class="wrap_section_contents">
	                        <div class="option_content area_section">
	                            <h2 class="blind">지역 선택</h2>
	                            <div class="select_keyword">
	                                <div class="wrap_auto_keyword">
	                                    <span class="ipt_keyword">
	                                        <label for="area_ipt_keyword" class="blind">지역명 입력</label>
	                                        <input type="text" name="loc" id="area_ipt_keyword" placeholder="지역명 입력" autocomplete="off">
	                                        <button type="button" class="btn_delete">삭제</button>
	                                    </span>
	                                    <div class="wrap_result has_result" id="autocomplete_has_result" style="display: none;">
	                                        <div class="wrap_scroll" style="height: 183px;">
	                                            <div class="ScrollBar">
	                                                <div class="track">
	                                                    <div class="thumb">
	                                                        <div class="end"></div>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                            <div class="viewport">
	                                                <div class="overview" style="top: 0px;">
	                                                    <ul class="list_keyword"></ul>
	                                                </div>
	                                            </div>
	                                        </div>
	                                        <div class="area_btn">
	                                            <button type="button" class="btn_close">닫기</button>
	                                        </div>
	                                    </div>
	                                    <div class="wrap_result no_result" id="autocomplete_no_result" style="display: none;">
	                                        <p class="empty">
	                                            검색결과가 없습니다.
	                                        </p>
	                                        <div class="area_btn">
	                                            <button type="button" class="btn_close">닫기</button>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                            <!-- 카테고리 depth -->
	                            <div class="wrap_depth_category ">
	                                <h4 class="blind">카테고리 선택</h4>
	                                <div class="wrap_scroll depth1" style="height: 245px;">
	                                    <div class="scrollbar" style="height: 245px;">
	                                        <div class="track" style="height: 245px;">
	                                            <div class="thumb" style="top: 4.7025px; height: 115.211px;">
	                                                <div class="end"></div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="viewport">
	                                        <div class="overview" style="top: -10px;">
	                                            <ul>
	                                                <li class="depth1_btn_wrapper on" id="depth1_btn_101000"><button type="button" class="depth1_btn_101000" data-code="101000"><span class="txt">서울 </span><span class="count">(58,664)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_102000"><button type="button" class="depth1_btn_102000" data-code="102000"><span class="txt">경기 </span><span class="count">(50,134)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_108000"><button type="button" class="depth1_btn_108000" data-code="108000"><span class="txt">인천 </span><span class="count">(8,877)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_106000"><button type="button" class="depth1_btn_106000" data-code="106000"><span class="txt">부산 </span><span class="count">(12,797)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_104000"><button type="button" class="depth1_btn_104000" data-code="104000"><span class="txt">대구 </span><span class="count">(7,799)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_103000"><button type="button" class="depth1_btn_103000" data-code="103000"><span class="txt">광주 </span><span class="count">(3,275)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_105000"><button type="button" class="depth1_btn_105000" data-code="105000"><span class="txt">대전 </span><span class="count">(4,584)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_107000"><button type="button" class="depth1_btn_107000" data-code="107000"><span class="txt">울산 </span><span class="count">(3,291)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_118000"><button type="button" class="depth1_btn_118000" data-code="118000"><span class="txt">세종 </span><span class="count">(1,353)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_109000"><button type="button" class="depth1_btn_109000" data-code="109000"><span class="txt">강원 </span><span class="count">(1,750)</span></button></li>
	                                                <li class="depth1_btn_wrapper" id="depth1_btn_110000"><button type="button" class="depth1_btn_110000" data-code="110000"><span class="txt">경남 </span><span class="count">(11,501)</span></button></li>
	                                                <li class="depth1_btn_wrapper" id="depth1_btn_111000"><button type="button" class="depth1_btn_111000" data-code="111000"><span class="txt">경북 </span><span class="count">(8,003)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_112000"><button type="button" class="depth1_btn_112000" data-code="112000"><span class="txt">전남 </span><span class="count">(3,607)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_113000"><button type="button" class="depth1_btn_113000" data-code="113000"><span class="txt">전북 </span><span class="count">(4,509)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_115000"><button type="button" class="depth1_btn_115000" data-code="115000"><span class="txt">충남 </span><span class="count">(8,219)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_114000"><button type="button" class="depth1_btn_114000" data-code="114000"><span class="txt">충북 </span><span class="count">(6,608)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_116000"><button type="button" class="depth1_btn_116000" data-code="116000"><span class="txt">제주 </span><span class="count">(1,594)</span></button></li>
	                                                <li class="depth1_btn_wrapper" id="depth1_btn_117000"><button type="button" class="depth1_btn_117000" data-code="117000"><span class="txt">전국 </span><span class="count">(564)</span></button></li>
	
	                                            </ul>
	                                            <!-- <ul class="list_overseas">
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_220200"><button type="button" class="depth1_btn_220200" data-code="220200"><span class="txt">미국 </span><span class="count">(129)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_211200"><button type="button" class="depth1_btn_211200" data-code="211200"><span class="txt">일본 </span><span class="count">(144)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_211300"><button type="button" class="depth1_btn_211300" data-code="211300"><span class="txt">중국·홍콩 </span><span class="count">(103)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_210000"><button type="button" class="depth1_btn_210000" data-code="210000"><span class="txt">아시아·중동 </span><span class="count">(697)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_220000"><button type="button" class="depth1_btn_220000" data-code="220000"><span class="txt">북·중미 </span><span class="count">(190)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_230000"><button type="button" class="depth1_btn_230000" data-code="230000"><span class="txt">남미 </span><span class="count">(17)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_240000"><button type="button" class="depth1_btn_240000" data-code="240000"><span class="txt">유럽 </span><span class="count">(75)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_250000"><button type="button" class="depth1_btn_250000" data-code="250000"><span class="txt">오세아니아 </span><span class="count">(4)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_260000"><button type="button" class="depth1_btn_260000" data-code="260000"><span class="txt">아프리카 </span><span class="count">(21)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_270000"><button type="button" class="depth1_btn_270000" data-code="270000"><span class="txt">남극대륙 </span><span class="count">(0)</span></button></li>
	                                                <li class="depth1_btn_wrapper " id="depth1_btn_280000"><button type="button" class="depth1_btn_280000" data-code="280000"><span class="txt">기타해외 </span><span class="count">(6)</span></button></li>
	                                            </ul> -->
	                                        </div>
	                                    </div>
	                                </div>
	                                <div class="wrap_scroll depth_check" style="height: 245px;">
	                                    <div class="scrollbar" style="height: 245px;">
	                                        <div class="track" style="height: 245px;">
	                                            <div class="thumb" style="top: 0px; height: 179.179px;">
	                                                <div class="end"></div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="viewport">
	                                        <div class="overview" style="top: 0px;">
	                                            <div class="wrap_list_check">
	                                                <ul class="list_check" id="sp_area_lastDepth_117000" style="display: none;">
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_mcd_117000" name="loc_mcd[]" value="117000" data-is_representative="n" data-representative="" data-mcode="117000" data-check-type="all">
	                                                            <label for="loc_mcd_117000" class="lbl"><span class="txt">전국</span></label>
	                                                        </div>
	                                                    </li>
	                                                </ul>
	
	                                                <ul class="list_check" id="sp_area_lastDepth_111000" style="display: none;">
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_mcd_111000" name="loc_mcd[]" value="111000" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="all">
	                                                            <label for="loc_mcd_111000" class="lbl"><span class="txt">경북전체</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111010" name="loc_cd[]" value="111010" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111010" class="lbl"><span class="txt">경산시</span><span class="count"> (1,180)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111020" name="loc_cd[]" value="111020" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111020" class="lbl"><span class="txt">경주시</span><span class="count"> (1,150)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111030" name="loc_cd[]" value="111030" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111030" class="lbl"><span class="txt">고령군</span><span class="count"> (188)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111040" name="loc_cd[]" value="111040" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111040" class="lbl"><span class="txt">구미시</span><span class="count"> (1,620)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111050" name="loc_cd[]" value="111050" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111050" class="lbl"><span class="txt">군위군</span><span class="count"> (0)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111060" name="loc_cd[]" value="111060" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111060" class="lbl"><span class="txt">김천시</span><span class="count"> (436)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111070" name="loc_cd[]" value="111070" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111070" class="lbl"><span class="txt">문경시</span><span class="count"> (186)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111080" name="loc_cd[]" value="111080" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111080" class="lbl"><span class="txt">봉화군</span><span class="count"> (36)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111090" name="loc_cd[]" value="111090" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111090" class="lbl"><span class="txt">상주시</span><span class="count"> (166)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111100" name="loc_cd[]" value="111100" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111100" class="lbl"><span class="txt">성주군</span><span class="count"> (284)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111110" name="loc_cd[]" value="111110" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111110" class="lbl"><span class="txt">안동시</span><span class="count"> (389)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111120" name="loc_cd[]" value="111120" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111120" class="lbl"><span class="txt">영덕군</span><span class="count"> (80)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111130" name="loc_cd[]" value="111130" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111130" class="lbl"><span class="txt">영양군</span><span class="count"> (22)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111140" name="loc_cd[]" value="111140" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111140" class="lbl"><span class="txt">영주시</span><span class="count"> (218)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111150" name="loc_cd[]" value="111150" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111150" class="lbl"><span class="txt">영천시</span><span class="count"> (490)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111160" name="loc_cd[]" value="111160" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111160" class="lbl"><span class="txt">예천군</span><span class="count"> (94)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111170" name="loc_cd[]" value="111170" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111170" class="lbl"><span class="txt">울릉군</span><span class="count"> (16)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111180" name="loc_cd[]" value="111180" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111180" class="lbl"><span class="txt">울진군</span><span class="count"> (49)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111190" name="loc_cd[]" value="111190" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111190" class="lbl"><span class="txt">의성군</span><span class="count"> (76)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111200" name="loc_cd[]" value="111200" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111200" class="lbl"><span class="txt">청도군</span><span class="count"> (116)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111210" name="loc_cd[]" value="111210" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111210" class="lbl"><span class="txt">청송군</span><span class="count"> (29)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111220" name="loc_cd[]" value="111220" data-is_representative="n" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111220" class="lbl"><span class="txt">칠곡군</span><span class="count"> (721)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111230" name="loc_cd[]" value="111230" data-is_representative="y" data-representative="" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111230" class="lbl"><span class="txt">포항시</span><span class="count"> (124)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111240" name="loc_cd[]" value="111240" data-is_representative="n" data-representative="111230" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111240" class="lbl"><span class="txt">포항시 남구</span><span class="count"> (618)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_111250" name="loc_cd[]" value="111250" data-is_representative="n" data-representative="111230" data-mcode="111000" data-check-type="">
	                                                            <label for="loc_cd_111250" class="lbl"><span class="txt">포항시 북구</span><span class="count"> (594)</span></label>
	                                                        </div>
	                                                    </li>
	                                                </ul>
	
	                                                <ul class="list_check" id="sp_area_lastDepth_110000" style="display: none;">
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_mcd_110000" name="loc_mcd[]" value="110000" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="all">
	                                                            <label for="loc_mcd_110000" class="lbl"><span class="txt">경남전체</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110010" name="loc_cd[]" value="110010" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110010" class="lbl"><span class="txt">거제시</span><span class="count"> (443)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110020" name="loc_cd[]" value="110020" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110020" class="lbl"><span class="txt">거창군</span><span class="count"> (102)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110030" name="loc_cd[]" value="110030" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110030" class="lbl"><span class="txt">고성군</span><span class="count"> (184)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110040" name="loc_cd[]" value="110040" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110040" class="lbl"><span class="txt">김해시</span><span class="count"> (2,972)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110050" name="loc_cd[]" value="110050" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110050" class="lbl"><span class="txt">남해군</span><span class="count"> (57)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110070" name="loc_cd[]" value="110070" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110070" class="lbl"><span class="txt">밀양시</span><span class="count"> (338)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110080" name="loc_cd[]" value="110080" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110080" class="lbl"><span class="txt">사천시</span><span class="count"> (380)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110090" name="loc_cd[]" value="110090" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110090" class="lbl"><span class="txt">산청군</span><span class="count"> (102)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110100" name="loc_cd[]" value="110100" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110100" class="lbl"><span class="txt">양산시</span><span class="count"> (1,680)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110110" name="loc_cd[]" value="110110" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110110" class="lbl"><span class="txt">의령군</span><span class="count"> (74)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110120" name="loc_cd[]" value="110120" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110120" class="lbl"><span class="txt">진주시</span><span class="count"> (1,046)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110140" name="loc_cd[]" value="110140" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110140" class="lbl"><span class="txt">창녕군</span><span class="count"> (306)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110150" name="loc_cd[]" value="110150" data-is_representative="y" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110150" class="lbl"><span class="txt">창원시</span><span class="count"> (2,126)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110055" name="loc_cd[]" value="110055" data-is_representative="n" data-representative="110150" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110055" class="lbl"><span class="txt">창원시 마산합포구</span><span class="count"> (287)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110053" name="loc_cd[]" value="110053" data-is_representative="n" data-representative="110150" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110053" class="lbl"><span class="txt">창원시 마산회원구</span><span class="count"> (343)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110057" name="loc_cd[]" value="110057" data-is_representative="n" data-representative="110150" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110057" class="lbl"><span class="txt">창원시 성산구</span><span class="count"> (595)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110059" name="loc_cd[]" value="110059" data-is_representative="n" data-representative="110150" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110059" class="lbl"><span class="txt">창원시 의창구</span><span class="count"> (608)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110130" name="loc_cd[]" value="110130" data-is_representative="n" data-representative="110150" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110130" class="lbl"><span class="txt">창원시 진해구</span><span class="count"> (324)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110160" name="loc_cd[]" value="110160" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110160" class="lbl"><span class="txt">통영시</span><span class="count"> (234)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110170" name="loc_cd[]" value="110170" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110170" class="lbl"><span class="txt">하동군</span><span class="count"> (79)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110180" name="loc_cd[]" value="110180" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110180" class="lbl"><span class="txt">함안군</span><span class="count"> (560)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110190" name="loc_cd[]" value="110190" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110190" class="lbl"><span class="txt">함양군</span><span class="count"> (85)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_110200" name="loc_cd[]" value="110200" data-is_representative="n" data-representative="" data-mcode="110000" data-check-type="">
	                                                            <label for="loc_cd_110200" class="lbl"><span class="txt">합천군</span><span class="count"> (93)</span></label>
	                                                        </div>
	                                                    </li>
	                                                </ul>
	
	                                                <ul class="list_check" id="sp_area_lastDepth_101000" style="display: block;">
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_mcd_101000" name="loc_mcd[]" value="101000" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="all">
	                                                            <label for="loc_mcd_101000" class="lbl"><span class="txt">서울전체</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101010" name="loc_cd[]" value="101010" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101010" class="lbl"><span class="txt">강남구</span><span class="count"> (18,448)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101020" name="loc_cd[]" value="101020" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101020" class="lbl"><span class="txt">강동구</span><span class="count"> (1,988)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101030" name="loc_cd[]" value="101030" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101030" class="lbl"><span class="txt">강북구</span><span class="count"> (710)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101040" name="loc_cd[]" value="101040" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101040" class="lbl"><span class="txt">강서구</span><span class="count"> (3,553)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101050" name="loc_cd[]" value="101050" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101050" class="lbl"><span class="txt">관악구</span><span class="count"> (2,133)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101060" name="loc_cd[]" value="101060" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101060" class="lbl"><span class="txt">광진구</span><span class="count"> (1,586)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101070" name="loc_cd[]" value="101070" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101070" class="lbl"><span class="txt">구로구</span><span class="count"> (3,432)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101080" name="loc_cd[]" value="101080" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101080" class="lbl"><span class="txt">금천구</span><span class="count"> (4,377)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101090" name="loc_cd[]" value="101090" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101090" class="lbl"><span class="txt">노원구</span><span class="count"> (873)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101100" name="loc_cd[]" value="101100" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101100" class="lbl"><span class="txt">도봉구</span><span class="count"> (455)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101110" name="loc_cd[]" value="101110" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101110" class="lbl"><span class="txt">동대문구</span><span class="count"> (1,257)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101120" name="loc_cd[]" value="101120" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101120" class="lbl"><span class="txt">동작구</span><span class="count"> (1,272)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101130" name="loc_cd[]" value="101130" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101130" class="lbl"><span class="txt">마포구</span><span class="count"> (4,326)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101140" name="loc_cd[]" value="101140" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101140" class="lbl"><span class="txt">서대문구</span><span class="count"> (1,188)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101150" name="loc_cd[]" value="101150" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101150" class="lbl"><span class="txt">서초구</span><span class="count"> (7,529)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101160" name="loc_cd[]" value="101160" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101160" class="lbl"><span class="txt">성동구</span><span class="count"> (3,464)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101170" name="loc_cd[]" value="101170" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101170" class="lbl"><span class="txt">성북구</span><span class="count"> (754)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101180" name="loc_cd[]" value="101180" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101180" class="lbl"><span class="txt">송파구</span><span class="count"> (5,346)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101190" name="loc_cd[]" value="101190" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101190" class="lbl"><span class="txt">양천구</span><span class="count"> (1,281)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101200" name="loc_cd[]" value="101200" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101200" class="lbl"><span class="txt">영등포구</span><span class="count"> (4,921)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101210" name="loc_cd[]" value="101210" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101210" class="lbl"><span class="txt">용산구</span><span class="count"> (2,256)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101220" name="loc_cd[]" value="101220" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101220" class="lbl"><span class="txt">은평구</span><span class="count"> (854)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101230" name="loc_cd[]" value="101230" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101230" class="lbl"><span class="txt">종로구</span><span class="count"> (2,099)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101240" name="loc_cd[]" value="101240" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101240" class="lbl"><span class="txt">중구</span><span class="count"> (3,640)</span></label>
	                                                        </div>
	                                                    </li>
	                                                    <li>
	                                                        <div class="inpChk">
	                                                            <input type="checkbox" id="loc_cd_101250" name="loc_cd[]" value="101250" data-is_representative="n" data-representative="" data-mcode="101000" data-check-type="">
	                                                            <label for="loc_cd_101250" class="lbl"><span class="txt">중랑구</span><span class="count"> (689)</span></label>
	                                                        </div>
	                                                    </li>
	                                                </ul>
	
	                                                <div class="area_btn">
	                                                    <button type="button" class="btn_all_category" data-logging-flow="area">지역 펼쳐보기</button>
	                                                    <button type="button" class="btn_reset">지역 초기화</button>
	                                                </div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="option_content job_category_section">
	                            <h2 class="blind">직업 선택</h2>
	                            <div class="select_keyword">
	                                <div class="wrap_auto_keyword">
	                                    <span class="ipt_keyword">
	                                        <label for="job_category_ipt_keyword" class="blind">직업(직무) 또는 전문분야 입력</label>
	                                        <input type="text" name="cat" id="job_category_ipt_keyword" placeholder="직업(직무) 또는 전문분야 입력" autocomplete="off">
	                                        <button type="button" class="btn_delete">삭제</button>
	                                    </span>
	                                    <div class="wrap_result has_result" id="autocomplete_has_result" style="display: none;">
	                                        <div class="wrap_scroll" style="height: 183px;">
	                                            <div class="ScrollBar">
	                                                <div class="track">
	                                                    <div class="thumb">
	                                                        <div class="end"></div>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                            <div class="viewport">
	                                                <div class="overview" style="top: 0px;">
	                                                    <ul class="list_keyword"></ul>
	                                                </div>
	                                            </div>
	                                        </div>
	                                        <div class="area_btn">
	                                            <button type="button" class="btn_close">닫기</button>
	                                        </div>
	                                    </div>
	                                    <div class="wrap_result no_result" id="autocomplete_no_result" style="display: none;">
	                                        <p class="empty">
	                                            검색결과가 없습니다.
	                                        </p>
	                                        <div class="area_btn">
	                                            <button type="button" class="btn_close">닫기</button>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                            <!-- 카테고리 depth -->
	                            <div class="details">
	                                <!-- wrap_depth_category -->
	                                <h4 class="blind">카테고리 선택</h4>
	
	                                <div class="box_jobs">
	                                    <script id="sp_job_category_home_template" type="text/x-handlebars-template">
                                        {{#mclsList}}
                                            {{#hasCountInJobCategory count}}
                                                <button type="button" class="btn_job" data-mcls_cd_no="{{mclsCdNo}}">{{mclsCdNm}}</button>
                                            {{/hasCountInJobCategory}}
                                        {{/mclsList}}
                                    </script><button type="button" class="btn_job" data-mcls_cd_no="16">기획·전략</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="14">마케팅·홍보·조사</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="3">회계·세무·재무</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="5">인사·노무·HRD</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="4">총무·법무·사무</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="2">IT개발·데이터</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="15">디자인</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="8">영업·판매·무역</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="21">고객상담·TM</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="18">구매·자재·물류</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="12">상품기획·MD</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="7">운전·운송·배송</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="10">서비스</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="11">생산</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="22">건설·건축</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="6">의료</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="9">연구·R&amp;D</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="19">교육</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="13">미디어·문화·스포츠</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="17">금융·보험</button>
	                                    <button type="button" class="btn_job" data-mcls_cd_no="20">공공·복지</button>
	                                </div>
	
	                                <div class="box_detail_jobs" style="display:none;">
	                                    <div class="box_onedepth">
	                                        <div class="wrap_scroll">
	                                            <div class="scrollbar">
	                                                <div class="track">
	                                                    <div class="thumb">
	                                                        <div class="end"></div>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                            <div class="viewport">
	                                                <ul class="list overview">
	                                                    <script id="sp_job_category_oneDepth_template" type="text/x-handlebars-template">
                                                        {{#mclsList}}
                                                            {{#hasCountInJobCategory count}}
                                                                <li class="item_job depth1_btn_wrapper" id="depth1_btn_{{mclsCdNo}}">
                                                                    <button type="button" data-mcls_cd_no="{{mclsCdNo}}" class="first_depth depth1_btn_{{mclsCdNo}}">
                                                                        <span class="txt">{{mclsCdNm}} </span>
                                                                        <span class="count">({{toStringByComma count}})</span>
                                                                    </button>
                                                                </li>
                                                            {{/hasCountInJobCategory}}
                                                        {{/mclsList}}
                                                    </script>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_16">
	                                                        <button type="button" data-mcls_cd_no="16" class="first_depth depth1_btn_16">
	                                                            <span class="txt">기획·전략 </span>
	                                                            <span class="count">(11,640)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_14">
	                                                        <button type="button" data-mcls_cd_no="14" class="first_depth depth1_btn_14">
	                                                            <span class="txt">마케팅·홍보·조사 </span>
	                                                            <span class="count">(11,678)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_3">
	                                                        <button type="button" data-mcls_cd_no="3" class="first_depth depth1_btn_3">
	                                                            <span class="txt">회계·세무·재무 </span>
	                                                            <span class="count">(9,965)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_5">
	                                                        <button type="button" data-mcls_cd_no="5" class="first_depth depth1_btn_5">
	                                                            <span class="txt">인사·노무·HRD </span>
	                                                            <span class="count">(4,056)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_4">
	                                                        <button type="button" data-mcls_cd_no="4" class="first_depth depth1_btn_4">
	                                                            <span class="txt">총무·법무·사무 </span>
	                                                            <span class="count">(14,139)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_2">
	                                                        <button type="button" data-mcls_cd_no="2" class="first_depth depth1_btn_2">
	                                                            <span class="txt">IT개발·데이터 </span>
	                                                            <span class="count">(12,061)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_15">
	                                                        <button type="button" data-mcls_cd_no="15" class="first_depth depth1_btn_15">
	                                                            <span class="txt">디자인 </span>
	                                                            <span class="count">(8,447)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_8">
	                                                        <button type="button" data-mcls_cd_no="8" class="first_depth depth1_btn_8">
	                                                            <span class="txt">영업·판매·무역 </span>
	                                                            <span class="count">(24,889)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_21">
	                                                        <button type="button" data-mcls_cd_no="21" class="first_depth depth1_btn_21">
	                                                            <span class="txt">고객상담·TM </span>
	                                                            <span class="count">(6,340)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_18">
	                                                        <button type="button" data-mcls_cd_no="18" class="first_depth depth1_btn_18">
	                                                            <span class="txt">구매·자재·물류 </span>
	                                                            <span class="count">(11,046)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_12">
	                                                        <button type="button" data-mcls_cd_no="12" class="first_depth depth1_btn_12">
	                                                            <span class="txt">상품기획·MD </span>
	                                                            <span class="count">(6,538)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_7">
	                                                        <button type="button" data-mcls_cd_no="7" class="first_depth depth1_btn_7">
	                                                            <span class="txt">운전·운송·배송 </span>
	                                                            <span class="count">(6,924)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_10">
	                                                        <button type="button" data-mcls_cd_no="10" class="first_depth depth1_btn_10">
	                                                            <span class="txt">서비스 </span>
	                                                            <span class="count">(25,266)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_11">
	                                                        <button type="button" data-mcls_cd_no="11" class="first_depth depth1_btn_11">
	                                                            <span class="txt">생산 </span>
	                                                            <span class="count">(38,961)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_22">
	                                                        <button type="button" data-mcls_cd_no="22" class="first_depth depth1_btn_22">
	                                                            <span class="txt">건설·건축 </span>
	                                                            <span class="count">(18,119)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_6">
	                                                        <button type="button" data-mcls_cd_no="6" class="first_depth depth1_btn_6">
	                                                            <span class="txt">의료 </span>
	                                                            <span class="count">(21,535)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_9">
	                                                        <button type="button" data-mcls_cd_no="9" class="first_depth depth1_btn_9">
	                                                            <span class="txt">연구·R&amp;D </span>
	                                                            <span class="count">(7,184)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_19">
	                                                        <button type="button" data-mcls_cd_no="19" class="first_depth depth1_btn_19">
	                                                            <span class="txt">교육 </span>
	                                                            <span class="count">(8,811)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_13">
	                                                        <button type="button" data-mcls_cd_no="13" class="first_depth depth1_btn_13">
	                                                            <span class="txt">미디어·문화·스포츠 </span>
	                                                            <span class="count">(5,932)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_17">
	                                                        <button type="button" data-mcls_cd_no="17" class="first_depth depth1_btn_17">
	                                                            <span class="txt">금융·보험 </span>
	                                                            <span class="count">(2,066)</span>
	                                                        </button>
	                                                    </li>
	                                                    <li class="item_job depth1_btn_wrapper" id="depth1_btn_20">
	                                                        <button type="button" data-mcls_cd_no="20" class="first_depth depth1_btn_20">
	                                                            <span class="txt">공공·복지 </span>
	                                                            <span class="count">(4,617)</span>
	                                                        </button>
	                                                    </li>
	                                                </ul>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="option_content keyword_section">
	                            <h2 class="blind">검색어 입력</h2>
	                            <div class="layer_search_keyword no_suggest" id="keywordAutoComplete">
	                                <div class="ipt_keyword">
	                                    <label for="total_ipt_keyword" class="blind">검색어 입력</label>
	                                    <input type="text" name="" id="total_ipt_keyword" class="search_keyword" maxlength="30" placeholder="검색어 입력" autocomplete="off">
	                                </div>
	                                <div class="total_recently_keyword wrap_scroll" style="display:none;">
	                                    <div class="scrollbar">
	                                        <div class="track">
	                                            <div class="thumb">
	                                                <div class="end"></div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="viewport">
	                                        <div class="overview">
	                                            <strong class="tit">최근 본 검색어</strong>
	                                            <ul></ul>
	                                        </div>
	                                    </div>
	                                </div>
	                                <div class="wrap_auto_complete wrap_scroll" id="wrapSuggestKeyword" style="display:none;">
	                                    <div class="scrollbar">
	                                        <div class="track">
	                                            <div class="thumb">
	                                                <div class="end"></div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="viewport">
	                                        <div class="overview">
	                                            <ul class="auto_complete"></ul>
	                                        </div>
	                                    </div>
	                                </div>
	                                <div class="info_auto_complete">
	                                    <p>최근 검색어와 리스트를<br>확인 할 수 있으며, 찾고자 하는<br>검색어를 자동 완성해 드립니다.</p>
	                                    <button type="button" class="btn_auto">자동완성 켜기</button>
	                                </div>
	                                <div class="area_btn">
	                                    <button type="button" class="btn_auto">자동완성 <span class="on" id="onoff">끄기</span></button>
	                                    <button type="button" class="btn_close_auto">닫기</button>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="option_content detail_option_section detail_section ">
	                            <h2 class="blind">상세조건</h2>
	                            <div id="sp_optional_wrapper" class="search_wrap wrap_detail_panel">
	                                <div class="base_area">
	                                    <div id="sp_salary" class="option_box salary">
	                                        <h2 class="option_title">
	                                            <label for="salary">연봉</label>
	                                        </h2>
	                                        <div class="option_list">
	                                            <div class="sri_select">
	                                                <button type="button" class="ico_arr selected">전체</button>
	                                                <input type="hidden" id="sal_min" name="sal_min" data-pass-onload-refresh="y" value="">
	                                                <ul id="sal_min_sel" class="list_opt">
	                                                    <li class="on"><a href="#none" class="link_opt" data-value="">전체</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="8" data-description="2,400만원 이상">2,400만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="9" data-description="2,600만원 이상">2,600만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="10" data-description="2,800만원 이상">2,800만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="11" data-description="3,000만원 이상">3,000만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="12" data-description="3,200만원 이상">3,200만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="13" data-description="3,400만원 이상">3,400만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="14" data-description="3,600만원 이상">3,600만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="15" data-description="3,800만원 이상">3,800만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="16" data-description="4,000만원 이상">4,000만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="17" data-description="5,000만원 이상">5,000만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="18" data-description="6,000만원 이상">6,000만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="19" data-description="7,000만원 이상">7,000만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="20" data-description="8,000만원 이상">8,000만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="21" data-description="9,000만원 이상">9,000만원 이상</a></li>
	                                                    <li><a href="#none" class="link_opt" data-value="22" data-description="1억원 이상">1억원 이상</a></li>
	                                                </ul>
	                                            </div>
	                                            <span class="inpChk small check_nocareer">
	                                                <input type="checkbox" id="sal_cd" name="sal_cd" value="0" data-description="회사내규에 따름 포함" data-pass-onload-refresh="y">
	                                                <label class="lbl" for="sal_cd">회사내규에 따름 포함</label>
	                                            </span>
	                                        </div>
	                                    </div>
	                                    <div id="sp_work_type" class="option_box job_form article_fold " style="display:block;">
	                                        <h2 class="option_title">재택근무</h2>
	                                        <div class="option_list">
	                                            <div class="sub_box">
	                                                <ul>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="work_type" name="work_type" value="1" data-value="1" data-description="재택근무 가능" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="work_type">재택근무 가능</label>
	                                                        </span>
	                                                    </li>
	                                                </ul>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div id="sp_industry" class="option_box job_field" style="display:block;">
	                                        <h2 class="option_title">업종</h2>
	                                        <div class="option_list depth1_wrapper">
	                                            <ul>
	                                                <li>
	                                                    <button type="button" id="sp_industry_1depth_1" class="btn_option job_category01 depth1" data-code="1">서비스업</button>
	                                                </li>
	                                                <li>
	                                                    <button type="button" id="sp_industry_1depth_7" class="btn_option job_category02 depth1" data-code="7">의료·제약·복지</button>
	                                                </li>
	                                                <li>
	                                                    <button type="button" id="sp_industry_1depth_2" class="btn_option job_category03 depth1" data-code="2">제조·화학</button>
	                                                </li>
	                                                <li>
	                                                    <button type="button" id="sp_industry_1depth_8" class="btn_option job_category04 depth1" data-code="8">판매·유통</button>
	                                                </li>
	                                                <li>
	                                                    <button type="button" id="sp_industry_1depth_3" class="btn_option job_category05 depth1" data-code="3">IT·웹·통신</button>
	                                                </li>
	                                                <li>
	                                                    <button type="button" id="sp_industry_1depth_9" class="btn_option job_category06 depth1" data-code="9">건설업</button>
	                                                </li>
	                                                <li>
	                                                    <button type="button" id="sp_industry_1depth_6" class="btn_option job_category07 depth1" data-code="6">교육업</button>
	                                                </li>
	                                                <li>
	                                                    <button type="button" id="sp_industry_1depth_5" class="btn_option job_category08 depth1" data-code="5">미디어·디자인</button>
	                                                </li>
	                                                <li>
	                                                    <button type="button" id="sp_industry_1depth_4" class="btn_option job_category09 depth1" data-code="4">은행·금융업</button>
	                                                </li>
	                                            </ul>
	                                            <ul>
	                                                <li>
	                                                    <button type="button" id="sp_industry_1depth_10" class="btn_option job_category10 depth1" data-code="10">기관·협회</button>
	                                                </li>
	                                            </ul>
	                                        </div>
	                                    </div>
	                                    <div id="sp_company_type" class="option_box company_form article_fold">
	                                        <h2 class="option_title">기업형태</h2>
	                                        <div class="option_list">
	                                            <div class="sub_box">
	                                                <ul>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_scale001" name="company_type[]" value="scale001" data-description="대기업" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_scale001">대기업</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_scale002" name="company_type[]" value="scale002" data-description="매출1000대기업" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_scale002">매출1000대기업</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_scale003" name="company_type[]" value="scale003" data-description="중견기업" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_scale003">중견기업</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_scale004" name="company_type[]" value="scale004" data-description="중소기업" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_scale004">중소기업</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_scale005" name="company_type[]" value="scale005" data-description="스타트업" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_scale005">스타트업</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_scale006" name="company_type[]" value="scale006" data-description="개인사업자" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_scale006">개인사업자</label>
	                                                        </span>
	                                                    </li>
	                                                </ul>
	                                            </div>
	                                            <div class="sub_box">
	                                                <ul>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_foreign" name="company_type[]" value="foreign" data-description="외국계(법인/투자)" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_foreign">외국계(법인/투자)</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_public" name="company_type[]" value="public" data-description="공사·공기업" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_public">공사·공기업</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_laboratory" name="company_type[]" value="laboratory" data-description="연구소" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_laboratory">연구소</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_school" name="company_type[]" value="school" data-description="학교·교육기관" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_school">학교·교육기관</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_social-welfare" name="company_type[]" value="social-welfare" data-description="사회복지기관" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_social-welfare">사회복지기관</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_banking-organ" name="company_type[]" value="banking-organ" data-description="금융기관" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_banking-organ">금융기관</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_nonprofit" name="company_type[]" value="nonprofit" data-description="비영리단체,협회" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_nonprofit">비영리단체,협회</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_medical-institution" name="company_type[]" value="medical-institution" data-description="병원,의료기관" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_medical-institution">병원,의료기관</label>
	                                                        </span>
	                                                    </li>
	                                                </ul>
	                                            </div>
	                                            <div class="sub_box">
	                                                <ul>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_kosdaq" name="company_type[]" value="kosdaq" data-description="코스닥" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_kosdaq">코스닥</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_kospi" name="company_type[]" value="kospi" data-description="코스피" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_kospi">코스피</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_konex" name="company_type[]" value="konex" data-description="코넥스" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_konex">코넥스</label>
	                                                        </span>
	                                                    </li>
	                                                </ul>
	                                            </div>
	                                            <div class="sub_box">
	                                                <ul>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_stock" name="company_type[]" value="stock" data-description="주식회사" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_stock">주식회사</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_incorporated" name="company_type[]" value="incorporated" data-description="유한회사" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_incorporated">유한회사</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_cooperative" name="company_type[]" value="cooperative" data-description="협동조합" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_cooperative">협동조합</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_corporate-juridical-person" name="company_type[]" value="corporate-juridical-person" data-description="사단법인" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_corporate-juridical-person">사단법인</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_foundation" name="company_type[]" value="foundation" data-description="재단법인" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_foundation">재단법인</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_ex_audit" name="company_type[]" value="ex_audit" data-description="외부감사법인" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_ex_audit">외부감사법인</label>
	                                                        </span>
	                                                        <div class="toolTipWrap company_form_guide">
	                                                            <button type="button" class="tooltip_btn"><span class="blind">외부감사법인 이란?</span></button>
	                                                            <div class="toolTip">
	                                                                <span class="tail tail_bottom_left"></span>
	                                                                <div class="toolTipCont">
	                                                                    <strong class="toolTipTit">외부감사법인 이란?</strong>
	                                                                    <p>직전연도 자산총액 70억원 이상인<br>기업으로 외부의 감사인으로부터<br>감사를 받은 법인입니다.</p>
	                                                                </div>
	                                                            </div>
	                                                        </div>
	                                                    </li>
	                                                </ul>
	                                            </div>
	                                            <div class="sub_box">
	                                                <ul>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_military" name="company_type[]" value="military" data-description="병역특례 인증 업체" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_military">병역특례 인증 업체</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="company_type_ex_import" name="company_type[]" value="ex_import" data-description="수출입기업" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="company_type_ex_import">수출입기업</label>
	                                                        </span>
	                                                    </li>
	                                                </ul>
	                                            </div>
	                                            <div class="set_open">
	                                                <button type="reset" class="btn_reset">선택 초기화</button>
	                                                <button type="button" class="btn_set btn_spread_item">펼치기</button>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div id="sp_job_type" class="option_box job_form article_fold" style="display:block;">
	                                        <h2 class="option_title">근무형태</h2>
	                                        <div class="option_list">
	                                            <div class="sub_box">
	                                                <ul>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="job_type_1" name="job_type[]" value="1" data-value="1" data-description="정규직" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="job_type_1">정규직</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="job_type_2" name="job_type[]" value="2" data-value="2" data-description="계약직" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="job_type_2">계약직</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="job_type_5" name="job_type[]" value="5" data-value="5" data-description="아르바이트" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="job_type_5">아르바이트</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="job_type_4" name="job_type[]" value="4" data-value="4" data-description="인턴직" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="job_type_4">인턴직</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="job_type_9" name="job_type[]" value="9" data-value="9" data-description="프리랜서" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="job_type_9">프리랜서</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="job_type_14" name="job_type[]" value="14" data-value="14" data-description="파트" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="job_type_14">파트</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="job_type_8" name="job_type[]" value="8" data-value="8" data-description="위촉직" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="job_type_8">위촉직</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="job_type_6" name="job_type[]" value="6" data-value="6" data-description="파견직" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="job_type_6">파견직</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="job_type_15" name="job_type[]" value="15" data-value="15" data-description="전임" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="job_type_15">전임</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="job_type_3" name="job_type[]" value="3" data-value="3" data-description="병역특례" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="job_type_3">병역특례</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="job_type_12" name="job_type[]" value="12" data-value="12" data-description="교육생" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="job_type_12">교육생</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="job_type_7" name="job_type[]" value="7" data-value="7" data-description="해외취업" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="job_type_7">해외취업</label>
	                                                        </span>
	                                                    </li>
	                                                </ul>
	                                            </div>
	                                            <div class="set_open">
	                                                <button type="reset" class="btn_reset">선택 초기화</button>
	                                                <button type="button" class="btn_set btn_spread_item">펼치기</button>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div id="sp_work_day" class="option_box job_day article_fold">
	                                        <h2 class="option_title">근무요일</h2>
	                                        <div class="option_list">
	                                            <div class="sub_box">
	                                                <ul>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="workday_wsh010" name="workday[]" value="wsh010" data-value="wsh010" data-description="주 5일(월~금)" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="workday_wsh010">주 5일(월~금)</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="workday_wsh030" name="workday[]" value="wsh030" data-value="wsh030" data-description="주 6일(월~토)" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="workday_wsh030">주 6일(월~토)</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="workday_wsh040" name="workday[]" value="wsh040" data-value="wsh040" data-description="주 3일(격일제)" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="workday_wsh040">주 3일(격일제)</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="workday_wsh050" name="workday[]" value="wsh050" data-value="wsh050" data-description="유연근무제" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="workday_wsh050">유연근무제</label>
	                                                        </span>
	                                                    </li>
	                                                    <li>
	                                                        <span class="inpChk small">
	                                                            <input type="checkbox" id="workday_wsh090" name="workday[]" value="wsh090" data-value="wsh090" data-description="면접 후 결정" data-pass-onload-refresh="y">
	                                                            <label class="lbl" for="workday_wsh090">면접 후 결정</label>
	                                                        </span>
	                                                    </li>
	                                                </ul>
	                                            </div>
	                                            <div class="set_open">
	                                                <button type="reset" class="btn_reset">선택 초기화</button>
	                                                <button type="button" class="btn_set btn_spread_item">펼치기</button>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div id="sp_welfare">
	                                        <div class="option_box welfare">
	                                            <h2 class="option_title">복리후생</h2>
	                                            <div class="option_list">
	                                                <button type="button" class="btn_welfare">검색하기</button>
	                                            </div>
	                                        </div>
	
	                                        <div id="sp_welfare_layer" class="layer_pop_manage search_layer welfare_list">
	                                            <h4>복리후생 선택</h4>
	                                            <p class="txt">* 최대 7개 까지 선택 가능합니다.</p>
	                                            <div class="layer_btn_area">
	                                                <button type="reset" class="btn_reset">전체선택 초기화</button>
	                                            </div>
	                                            <div class="table_scroll">
	                                                <table class="default_table welfare_select_table">
	                                                    <caption>복리후생 리스트</caption>
	                                                    <colgroup>
	                                                        <col style="width:20%">
	                                                        <col style="width:20%">
	                                                        <col style="width:20%">
	                                                        <col style="width:20%">
	                                                        <col style="width:20%">
	                                                    </colgroup>
	                                                    <tbody>
	                                                        <tr>
	                                                            <th>지원금/보험</th>
	                                                            <th>급여제도</th>
	                                                            <th>선물</th>
	                                                            <th>교육/생활</th>
	                                                            <th>근무 환경</th>
	                                                        </tr>
	                                                        <tr>
	                                                            <td>
	                                                                <ul class="chk_list">
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp407" name="welfare_cd[]" value="corp407" data-description="건강검진" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp407">건강검진</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp408" name="welfare_cd[]" value="corp408" data-description="의료비지원(본인)" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp408">의료비지원(본인)</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp409" name="welfare_cd[]" value="corp409" data-description="금연수당" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp409">금연수당</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp411" name="welfare_cd[]" value="corp411" data-description="직원대출제도" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp411">직원대출제도</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp417" name="welfare_cd[]" value="corp417" data-description="각종 경조사 지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp417">각종 경조사 지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp419" name="welfare_cd[]" value="corp419" data-description="단체 상해보험" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp419">단체 상해보험</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp439" name="welfare_cd[]" value="corp439" data-description="의료비지원(가족)" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp439">의료비지원(가족)</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp440" name="welfare_cd[]" value="corp440" data-description="체력단련실운영" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp440">체력단련실운영</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp441" name="welfare_cd[]" value="corp441" data-description="헬스비 지급" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp441">헬스비 지급</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp442" name="welfare_cd[]" value="corp442" data-description="무료진료지정병원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp442">무료진료지정병원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp486" name="welfare_cd[]" value="corp486" data-description="본인학자금" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp486">본인학자금</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp487" name="welfare_cd[]" value="corp487" data-description="업무활동비 지급" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp487">업무활동비 지급</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp488" name="welfare_cd[]" value="corp488" data-description="문화생활비" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp488">문화생활비</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp489" name="welfare_cd[]" value="corp489" data-description="통신비 지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp489">통신비 지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp490" name="welfare_cd[]" value="corp490" data-description="결혼준비 지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp490">결혼준비 지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp491" name="welfare_cd[]" value="corp491" data-description="해외여행 지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp491">해외여행 지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp492" name="welfare_cd[]" value="corp492" data-description="선택적복리후생" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp492">선택적복리후생</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp495" name="welfare_cd[]" value="corp495" data-description="복지카드/포인트" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp495">복지카드/포인트</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp496" name="welfare_cd[]" value="corp496" data-description="난임 치료 지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp496">난임 치료 지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp497" name="welfare_cd[]" value="corp497" data-description="주요 제품 직원 할인" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp497">주요 제품 직원 할인</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp498" name="welfare_cd[]" value="corp498" data-description="자녀학자금" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp498">자녀학자금</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp534" name="welfare_cd[]" value="corp534" data-description="사내 결혼식장 제공" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp534">사내 결혼식장 제공</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp537" name="welfare_cd[]" value="corp537" data-description="내일채움공제" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp537">내일채움공제</label>
	                                                                        </span>
	                                                                    </li>
	                                                                </ul>
	                                                            </td>
	                                                            <td>
	                                                                <ul class="chk_list">
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp400" name="welfare_cd[]" value="corp400" data-description="퇴직연금" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp400">퇴직연금</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp401" name="welfare_cd[]" value="corp401" data-description="인센티브제" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp401">인센티브제</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp402" name="welfare_cd[]" value="corp402" data-description="상여금" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp402">상여금</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp403" name="welfare_cd[]" value="corp403" data-description="장기근속자 포상" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp403">장기근속자 포상</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp404" name="welfare_cd[]" value="corp404" data-description="우수사원포상" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp404">우수사원포상</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp405" name="welfare_cd[]" value="corp405" data-description="스톡옵션" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp405">스톡옵션</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp406" name="welfare_cd[]" value="corp406" data-description="퇴직금" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp406">퇴직금</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp420" name="welfare_cd[]" value="corp420" data-description="성과급" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp420">성과급</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp421" name="welfare_cd[]" value="corp421" data-description="야근수당" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp421">야근수당</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp422" name="welfare_cd[]" value="corp422" data-description="휴일(특근)수당" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp422">휴일(특근)수당</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp423" name="welfare_cd[]" value="corp423" data-description="연차수당" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp423">연차수당</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp424" name="welfare_cd[]" value="corp424" data-description="직책수당" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp424">직책수당</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp425" name="welfare_cd[]" value="corp425" data-description="자격증수당" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp425">자격증수당</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp426" name="welfare_cd[]" value="corp426" data-description="장기근속수당" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp426">장기근속수당</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp427" name="welfare_cd[]" value="corp427" data-description="위험수당" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp427">위험수당</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp428" name="welfare_cd[]" value="corp428" data-description="가족수당" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp428">가족수당</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp499" name="welfare_cd[]" value="corp499" data-description="4대 보험" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp499">4대 보험</label>
	                                                                        </span>
	                                                                    </li>
	                                                                </ul>
	                                                            </td>
	                                                            <td>
	                                                                <ul class="chk_list">
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp434" name="welfare_cd[]" value="corp434" data-description="명절선물/귀향비" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp434">명절선물/귀향비</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp435" name="welfare_cd[]" value="corp435" data-description="창립일선물지급" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp435">창립일선물지급</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp436" name="welfare_cd[]" value="corp436" data-description="생일선물/파티" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp436">생일선물/파티</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp437" name="welfare_cd[]" value="corp437" data-description="크리스마스 선물" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp437">크리스마스 선물</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp438" name="welfare_cd[]" value="corp438" data-description="결혼기념일선물" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp438">결혼기념일선물</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp500" name="welfare_cd[]" value="corp500" data-description="도서 무제한 제공" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp500">도서 무제한 제공</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp501" name="welfare_cd[]" value="corp501" data-description="임신/출산 선물" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp501">임신/출산 선물</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp502" name="welfare_cd[]" value="corp502" data-description="웰컴키트 지급" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp502">웰컴키트 지급</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp503" name="welfare_cd[]" value="corp503" data-description="생일자 조기퇴근" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp503">생일자 조기퇴근</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp532" name="welfare_cd[]" value="corp532" data-description="장기근속 선물" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp532">장기근속 선물</label>
	                                                                        </span>
	                                                                    </li>
	                                                                </ul>
	                                                            </td>
	                                                            <td>
	                                                                <ul class="chk_list">
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp100" name="welfare_cd[]" value="corp100" data-description="창립일행사" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp100">창립일행사</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp101" name="welfare_cd[]" value="corp101" data-description="우수사원시상식" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp101">우수사원시상식</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp102" name="welfare_cd[]" value="corp102" data-description="워크샵" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp102">워크샵</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp103" name="welfare_cd[]" value="corp103" data-description="플레이샵" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp103">플레이샵</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp200" name="welfare_cd[]" value="corp200" data-description="신규 입사자 교육(OJT)" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp200">신규 입사자 교육(OJT)</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp201" name="welfare_cd[]" value="corp201" data-description="직무능력향상교육" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp201">직무능력향상교육</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp202" name="welfare_cd[]" value="corp202" data-description="리더십 강화교육" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp202">리더십 강화교육</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp203" name="welfare_cd[]" value="corp203" data-description="해외연수지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp203">해외연수지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp204" name="welfare_cd[]" value="corp204" data-description="도서구입비지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp204">도서구입비지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp205" name="welfare_cd[]" value="corp205" data-description="MBA과정지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp205">MBA과정지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp206" name="welfare_cd[]" value="corp206" data-description="멘토링제도" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp206">멘토링제도</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp207" name="welfare_cd[]" value="corp207" data-description="외국어 교육 지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp207">외국어 교육 지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp208" name="welfare_cd[]" value="corp208" data-description="사이버연수원운영" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp208">사이버연수원운영</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp209" name="welfare_cd[]" value="corp209" data-description="자격증취득지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp209">자격증취득지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp210" name="welfare_cd[]" value="corp210" data-description="교육비 지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp210">교육비 지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp211" name="welfare_cd[]" value="corp211" data-description="자기계발비 지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp211">자기계발비 지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp413" name="welfare_cd[]" value="corp413" data-description="구내식당(사원식당)" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp413">구내식당(사원식당)</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp415" name="welfare_cd[]" value="corp415" data-description="점심식사 제공" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp415">점심식사 제공</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp416" name="welfare_cd[]" value="corp416" data-description="저녁식사 제공" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp416">저녁식사 제공</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp418" name="welfare_cd[]" value="corp418" data-description="사내동호회 운영" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp418">사내동호회 운영</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp429" name="welfare_cd[]" value="corp429" data-description="사우회(경조사회)" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp429">사우회(경조사회)</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp469" name="welfare_cd[]" value="corp469" data-description="아침식사 제공" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp469">아침식사 제공</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp470" name="welfare_cd[]" value="corp470" data-description="간식 제공" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp470">간식 제공</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp471" name="welfare_cd[]" value="corp471" data-description="식비 지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp471">식비 지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp472" name="welfare_cd[]" value="corp472" data-description="음료제공(차, 커피)" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp472">음료제공(차, 커피)</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp493" name="welfare_cd[]" value="corp493" data-description="해외주재원 제도" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp493">해외주재원 제도</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp494" name="welfare_cd[]" value="corp494" data-description="우리사주제도" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp494">우리사주제도</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp504" name="welfare_cd[]" value="corp504" data-description="해외 워크샵" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp504">해외 워크샵</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp505" name="welfare_cd[]" value="corp505" data-description="점심시간 연장제도" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp505">점심시간 연장제도</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp506" name="welfare_cd[]" value="corp506" data-description="취미 프로그램 운영" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp506">취미 프로그램 운영</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp507" name="welfare_cd[]" value="corp507" data-description="가족 초청 행사" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp507">가족 초청 행사</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp531" name="welfare_cd[]" value="corp531" data-description="신규입사자 멘토 제도" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp531">신규입사자 멘토 제도</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp536" name="welfare_cd[]" value="corp536" data-description="컨퍼런스 개최" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp536">컨퍼런스 개최</label>
	                                                                        </span>
	                                                                    </li>
	                                                                </ul>
	                                                            </td>
	                                                            <td>
	                                                                <ul class="chk_list">
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp443" name="welfare_cd[]" value="corp443" data-description="수유실" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp443">수유실</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp444" name="welfare_cd[]" value="corp444" data-description="사내 어린이집 운영" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp444">사내 어린이집 운영</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp449" name="welfare_cd[]" value="corp449" data-description="휴게실" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp449">휴게실</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp450" name="welfare_cd[]" value="corp450" data-description="수면실" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp450">수면실</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp451" name="welfare_cd[]" value="corp451" data-description="회의실" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp451">회의실</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp452" name="welfare_cd[]" value="corp452" data-description="공기청정기" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp452">공기청정기</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp453" name="welfare_cd[]" value="corp453" data-description="카페테리아" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp453">카페테리아</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp454" name="welfare_cd[]" value="corp454" data-description="게임기" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp454">게임기</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp455" name="welfare_cd[]" value="corp455" data-description="전용 사옥" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp455">전용 사옥</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp457" name="welfare_cd[]" value="corp457" data-description="사내 정원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp457">사내 정원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp458" name="welfare_cd[]" value="corp458" data-description="건물 내 경사로" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp458">건물 내 경사로</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp459" name="welfare_cd[]" value="corp459" data-description="휠체어용 난간" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp459">휠체어용 난간</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp460" name="welfare_cd[]" value="corp460" data-description="유도점자블록" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp460">유도점자블록</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp461" name="welfare_cd[]" value="corp461" data-description="장애인 화장실" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp461">장애인 화장실</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp462" name="welfare_cd[]" value="corp462" data-description="장애인 전용주차장" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp462">장애인 전용주차장</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp463" name="welfare_cd[]" value="corp463" data-description="장애인 엘리베이터" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp463">장애인 엘리베이터</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp464" name="welfare_cd[]" value="corp464" data-description="비상경보장치" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp464">비상경보장치</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp465" name="welfare_cd[]" value="corp465" data-description="문턱 없음" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp465">문턱 없음</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp468" name="welfare_cd[]" value="corp468" data-description="유니폼지급" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp468">유니폼지급</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp481" name="welfare_cd[]" value="corp481" data-description="스마트기기" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp481">스마트기기</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp482" name="welfare_cd[]" value="corp482" data-description="노트북" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp482">노트북</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp483" name="welfare_cd[]" value="corp483" data-description="사원증" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp483">사원증</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp484" name="welfare_cd[]" value="corp484" data-description="자회사 제품할인" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp484">자회사 제품할인</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp485" name="welfare_cd[]" value="corp485" data-description="콘도/리조트 이용권" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp485">콘도/리조트 이용권</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp508" name="welfare_cd[]" value="corp508" data-description="사내도서관" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp508">사내도서관</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp509" name="welfare_cd[]" value="corp509" data-description="사무용품 지급" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp509">사무용품 지급</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp510" name="welfare_cd[]" value="corp510" data-description="최고 성능 컴퓨터" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp510">최고 성능 컴퓨터</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp511" name="welfare_cd[]" value="corp511" data-description="안마실/안마의자" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp511">안마실/안마의자</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp512" name="welfare_cd[]" value="corp512" data-description="사내 의원/약국" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp512">사내 의원/약국</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp513" name="welfare_cd[]" value="corp513" data-description="스탠딩 책상" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp513">스탠딩 책상</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp538" name="welfare_cd[]" value="corp538" data-description="비자 발급 지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp538">비자 발급 지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                </ul>
	                                                            </td>
	                                                        </tr>
	                                                        <tr>
	                                                            <th>조직문화</th>
	                                                            <th>출퇴근</th>
	                                                            <th>리프레시</th>
	                                                        </tr>
	                                                        <tr>
	                                                            <td>
	                                                                <ul class="chk_list">
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp309" name="welfare_cd[]" value="corp309" data-description="무제한 연차" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp309">무제한 연차</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp430" name="welfare_cd[]" value="corp430" data-description="노조/노사협의회" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp430">노조/노사협의회</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp431" name="welfare_cd[]" value="corp431" data-description="수평적 조직문화" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp431">수평적 조직문화</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp432" name="welfare_cd[]" value="corp432" data-description="회식강요 안함" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp432">회식강요 안함</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp433" name="welfare_cd[]" value="corp433" data-description="야근강요 안함" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp433">야근강요 안함</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp466" name="welfare_cd[]" value="corp466" data-description="자유복장" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp466">자유복장</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp467" name="welfare_cd[]" value="corp467" data-description="캐주얼데이" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp467">캐주얼데이</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp514" name="welfare_cd[]" value="corp514" data-description="자유로운 연차사용" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp514">자유로운 연차사용</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp515" name="welfare_cd[]" value="corp515" data-description="님/닉네임 문화" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp515">님/닉네임 문화</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp516" name="welfare_cd[]" value="corp516" data-description="출산 장려" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp516">출산 장려</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp518" name="welfare_cd[]" value="corp518" data-description="칼퇴근 보장" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp518">칼퇴근 보장</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp519" name="welfare_cd[]" value="corp519" data-description="반려동물 동반출근" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp519">반려동물 동반출근</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp520" name="welfare_cd[]" value="corp520" data-description="문화 회식" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp520">문화 회식</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp533" name="welfare_cd[]" value="corp533" data-description="사내연애 장려" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp533">사내연애 장려</label>
	                                                                        </span>
	                                                                    </li>
	                                                                </ul>
	                                                            </td>
	                                                            <td>
	                                                                <ul class="chk_list">
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp410" name="welfare_cd[]" value="corp410" data-description="기숙사 운영" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp410">기숙사 운영</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp412" name="welfare_cd[]" value="corp412" data-description="차량유류비지급" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp412">차량유류비지급</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp414" name="welfare_cd[]" value="corp414" data-description="통근버스 운행" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp414">통근버스 운행</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp473" name="welfare_cd[]" value="corp473" data-description="사택제공" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp473">사택제공</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp474" name="welfare_cd[]" value="corp474" data-description="사원아파트 임대" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp474">사원아파트 임대</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp475" name="welfare_cd[]" value="corp475" data-description="주택자금 융자" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp475">주택자금 융자</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp476" name="welfare_cd[]" value="corp476" data-description="야간교통비지급" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp476">야간교통비지급</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp477" name="welfare_cd[]" value="corp477" data-description="주차장제공" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp477">주차장제공</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp478" name="welfare_cd[]" value="corp478" data-description="주차비지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp478">주차비지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp479" name="welfare_cd[]" value="corp479" data-description="회사차량 있음" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp479">회사차량 있음</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp480" name="welfare_cd[]" value="corp480" data-description="탄력근무제" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp480">탄력근무제</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp521" name="welfare_cd[]" value="corp521" data-description="주거비 지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp521">주거비 지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp522" name="welfare_cd[]" value="corp522" data-description="전세자금 대출" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp522">전세자금 대출</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp523" name="welfare_cd[]" value="corp523" data-description="출퇴근 교통비 지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp523">출퇴근 교통비 지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp524" name="welfare_cd[]" value="corp524" data-description="재택근무" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp524">재택근무</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp525" name="welfare_cd[]" value="corp525" data-description="주 52시간제 준수" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp525">주 52시간제 준수</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp526" name="welfare_cd[]" value="corp526" data-description="주 40시간제 시행" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp526">주 40시간제 시행</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp527" name="welfare_cd[]" value="corp527" data-description="주4.5일" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp527">주4.5일</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp528" name="welfare_cd[]" value="corp528" data-description="주4일" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp528">주4일</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp535" name="welfare_cd[]" value="corp535" data-description="자율 근무제" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp535">자율 근무제</label>
	                                                                        </span>
	                                                                    </li>
	                                                                </ul>
	                                                            </td>
	                                                            <td>
	                                                                <ul class="chk_list">
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp300" name="welfare_cd[]" value="corp300" data-description="연차" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp300">연차</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp301" name="welfare_cd[]" value="corp301" data-description="여름휴가" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp301">여름휴가</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp302" name="welfare_cd[]" value="corp302" data-description="경조휴가제" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp302">경조휴가제</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp303" name="welfare_cd[]" value="corp303" data-description="반차" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp303">반차</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp304" name="welfare_cd[]" value="corp304" data-description="Refresh휴가" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp304">Refresh휴가</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp305" name="welfare_cd[]" value="corp305" data-description="창립일휴무" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp305">창립일휴무</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp306" name="welfare_cd[]" value="corp306" data-description="근로자의 날 휴무" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp306">근로자의 날 휴무</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp307" name="welfare_cd[]" value="corp307" data-description="휴가비지원" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp307">휴가비지원</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp308" name="welfare_cd[]" value="corp308" data-description="포상휴가" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp308">포상휴가</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp445" name="welfare_cd[]" value="corp445" data-description="산전 후 휴가" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp445">산전 후 휴가</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp446" name="welfare_cd[]" value="corp446" data-description="육아휴직" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp446">육아휴직</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp447" name="welfare_cd[]" value="corp447" data-description="남성출산휴가" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp447">남성출산휴가</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp448" name="welfare_cd[]" value="corp448" data-description="보건휴가" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp448">보건휴가</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp456" name="welfare_cd[]" value="corp456" data-description="휴양시설 제공" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp456">휴양시설 제공</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp529" name="welfare_cd[]" value="corp529" data-description="패밀리데이" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp529">패밀리데이</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp530" name="welfare_cd[]" value="corp530" data-description="시간제 연차" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp530">시간제 연차</label>
	                                                                        </span>
	                                                                    </li>
	                                                                    <li class="chk_item">
	                                                                        <span class="inpChk small">
	                                                                            <input type="checkbox" id="welfare_cd_corp310" name="welfare_cd[]" value="corp310" data-description="공휴일 휴무" data-pass-onload-refresh="y">
	                                                                            <label class="lbl" for="welfare_cd_corp310">공휴일 휴무</label>
	                                                                        </span>
	                                                                    </li>
	                                                                </ul>
	                                                            </td>
	                                                        </tr>
	                                                    </tbody>
	                                                </table>
	                                            </div>
	                                            <div class="bottom_btn_wrap">
	                                                <button type="button" class="btn_basic_type01 btn_register">선택완료</button>
	                                            </div>
	                                            <button type="button" class="btn_close"><span>닫기</span></button>
	                                        </div>
	
	                                    </div>
	                                    <div id="sp_keyword" class="option_box search_word">
	                                        <h2 class="option_title">제외 검색어</h2>
	                                        <div class="option_list">
	                                            <div class="search_word_wrap select_space">
	                                                <input type="text" id="exc_keyword" name="exc_keyword" class="inpTypo placeholder" data-description="제외 &gt; " maxlength="20" title="여러 개의 단어를 입력하실 때는 쉼표( , )로 구분해서 입력하세요.(예. 디자인, 웹, 마케팅)">
	                                                <button type="button" class="btn_input_delete btn_reset_exclude"><span>삭제</span></button>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="bg"></div>
	                <div id="sp_preview" class="wrap_search_result preview_v2 resetting" style="">
	                    <div class="add_keyword">
	                        <div id="sp_preview_selected" class="keywords" style="display: none;"></div>
	                        <p class="result_txt">채용공고를 찾고 있습니다. 잠시만 기다려주세요.</p>
	                        <p class="reset_txt">검색조건을 설정해 주세요.</p>
	                    </div>
	                    <div class="area_btn">
	                        <button type="button" class="btn_expand" style="display: none;">펼쳐보기</button>
	                        <button type="button" class="btn_reset" style="display: none;">선택초기화</button>
	                    </div>
	                    <button type="button" id="search_btn" class="btn_search search_reset active">
	                        <span>
	                            <span class="count"><span id="search_count_txt">선택된 </span><b id="sp_preview_total_cnt">0</b>건</span>
	                            <span id="search_btn_txt">검색하기</span>
	                        </span>
	                        <span class="ripple"></span>
	                    </button>
	                </div>
	
	            </div>
	        </fieldset>
	    </form>
	</div>
</div>