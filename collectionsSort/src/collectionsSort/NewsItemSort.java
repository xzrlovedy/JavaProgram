package collectionsSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 使用Collections工具类对新闻条目进行排序
 * 
 * @author Administrator
 *
 */
public class NewsItemSort {
	public static void main(String[] args) {
		List<NewsItem> news = new ArrayList<NewsItem>();
		news.add(new NewsItem("美国后怕了，逃跑了悲剧了", 50, 
				new Date(System.currentTimeMillis() - 1000 * 60 * 60)));// 一小时前
		news.add(new NewsItem("中国登上钓鱼岛了，全国欢呼了", 100, new Date()));// 时间现在
		news.add(new NewsItem("小日本终于听话了，泪流满面笑了", 60, 
				new Date(System.currentTimeMillis() - 1000 * 60 * 60)));
		System.out.println("排序前:" + "\n" + news);
		// 排序后
		Collections.sort(news);
		System.out.println("排序后" + "\n" + news);
	}
}
