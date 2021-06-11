/*
 *  Copyright (c) 2019-2020, lzh (lzh0813@gmail.com).
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 * https://www.gnu.org/licenses/lgpl.html
 *  <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.web.base.constants;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author lzh
 * @date 2019/2/1
 */
public interface CommonConstants {

	/**
	 * 编码
	 */
	String UTF8 = "UTF-8";

	/**
	 * JSON 资源
	 */
	String CONTENT_TYPE = "application/json; charset=utf-8";

	/**
	 * 成功标记
	 */
	Integer SUCCESS = 0;
	/**
	 * 失败标记
	 */
	Integer FAIL = -1;

	public static final String[] WEEK_STR = {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};

	public static DateTimeFormatter dateTimeFormatterStandard = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static DateTimeFormatter dateTimeFormatterFirst = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static DateTimeFormatter dateTimeFormatterSecond = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	public static DateTimeFormatter dateTimeFormatterThird = DateTimeFormatter.ofPattern("HH:mm");

	public static DateTimeFormatter dateTimeFormatterFour = DateTimeFormatter.ofPattern("M.d");

	public static final ZoneOffset ZONE_OFFSET = ZoneOffset.ofHours(8);
}
