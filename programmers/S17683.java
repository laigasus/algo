import java.util.PriorityQueue;

public class S17683 {

    static class Solution {
        static class Music {
            String title;
            int playTime;

            public Music(String title, int playTime) {
                this.title = title;
                this.playTime = playTime;
            }
        }

        private static final String NONE = "(None)";

        public static String solution(String m, String[] musicinfos) {
            PriorityQueue<Music> playlist = new PriorityQueue<>((m1, m2) -> m2.playTime - m1.playTime);

            for (var musicinfo : musicinfos) {
                String[] data = musicinfo.split(",");

                int playTime = convertTime(data[1]) - convertTime(data[0]);
                String title = data[2];
                String notes = convertNotes(data[3]);
                String melody = convertNotes(m);

                if (playTime < melody.length()) {
                    continue;
                }
                notes = convertNotes(notes, playTime);

                if (notes.contains(melody)) {
                    playlist.offer(new Music(title, playTime));
                }
            }

            return playlist.isEmpty() ? NONE : playlist.poll().title;
        }

        private static int convertTime(String time) {
            String[] tmp = time.split(":");
            return 60 * Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[1]);
        }

        private static String convertNotes(String score, int playTime) {
            StringBuilder sb = new StringBuilder();

            int idx = 0;
            while (playTime-- > 0) {
                sb.append(score.charAt(idx++ % score.length()));
            }
            return sb.toString();
        }

        private static String convertNotes(String score) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < score.length(); i++) {
                char c = score.charAt(i);
                if (c == '#') {
                    char lastInsertedChar = sb.charAt(sb.length() - 1);
                    sb.setCharAt(sb.length() - 1, Character.toLowerCase(lastInsertedChar));
                } else {
                    sb.append(c);
                }

            }
            return sb.toString();
        }

    }

    public static void main(String[] args) {
        System.out.println(Solution.solution("ABCDEFG",
                new String[] {
                        "12:00,12:14,HELLO,CDEFGAB",
                        "13:00,13:05,WORLD,ABCDEF"
                }));

        System.out.println(Solution.solution("CC#BCC#BCC#BCC#B",
                new String[] {
                        "03:00,03:30,FOO,CC#B",
                        "04:00,04:08,BAR,CC#BCC#BCC#B"
                }));

        System.out.println(Solution.solution("ABC",
                new String[] {
                        "12:00,12:14,HELLO,C#DEFGAB",
                        "13:00,13:05,WORLD,ABCDEF"
                }));
    }
}
