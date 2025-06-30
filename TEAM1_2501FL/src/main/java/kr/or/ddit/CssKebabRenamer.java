package kr.or.ddit;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CssKebabRenamer {
	public static void main(String[] args) throws Exception {
        Path in  = Paths.get("src/main/resources/static/dist/assets/css/test.css");
        Path out = Paths.get("src/main/resources/static/dist/assets/css/kebab.css");

        String css = Files.readString(in);

        // 1) “.className” 에서 className 부분만 잡아낸다
        Pattern p = Pattern.compile("(?<=\\.)[A-Za-z0-9_]+");
        Matcher m = p.matcher(css);

        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String orig = m.group();  
            // 2) camelCase → kebab-case
            String kebab = orig
                .replaceAll("([a-z0-9])([A-Z])", "$1-$2")  // FooBar → Foo-Bar
                .toLowerCase();                          // Foo-Bar → foo-bar
            m.appendReplacement(sb, kebab);
        }
        m.appendTail(sb);

        Files.writeString(out, sb.toString());
        System.out.println("✅ 변환 완료 → " + out.toAbsolutePath());
    }
}
