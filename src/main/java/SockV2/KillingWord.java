package SockV2;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Random;

public class KillingWord {

    private static String[] killingWhen = {"10초 후에", "내일", "모레", "언젠가", "다음 주에", "한달 뒤에", "1년 뒤에", "10년 뒤에", "100년 뒤에", "5년 뒤에", "1시간 후에", "6시간 후에", "아침에", "점심에", "저녁에", "새벽에", "밤에", "잠시 후에", "1분 뒤에", "10분 뒤에", "곧", "오늘", "수일 내로"};
    private static String[] killingWhere = {"카페", "초등학교", "집", "병원", "동사무소", "식당", "산", "바다", "계곡", "비행기", "지하철", "버스", "택시", "차", "기차", "중학교", "고등학교", "대학교", "여학교", "마트", "은행", "편의점", "시장", "보건소", "경비실", "화장실", "강", "하천", "운동장", "강변", "영화관", "터미널", "역", "옥상", "경찰서", "소방서", "초소", "군대", "취사장", "사격장", "공원", "공동묘지", "워터파크", "찜질방", "샤워실", "목욕탕", "클럽", "당구장", "볼링장", "피시방", "안마방", "노래방", "대딸방", "노인정", "사우나", "성인용품점", "러브호텔", "피시방", "국어학원", "수학학원", "영어학원", "과학학원", "기숙학원", "기숙사", "독서실", "대형마트", "스터디카페", "노약자석", "임산부석", "장애인석", "대형마트시식코너", "경찰서", "대중목욕탕", "무료급식소", "초등학교", "중학교", "고등학교", "편의점", "학원가", "세탁소", "풋살장", "미용실", "찜질방", "동사무소", "전통시장", "태권도장", "놀이터", "헬스장", "할매순댓국밥집", "버스정류장", "삼성프라자", "국회의사당", "흡연실", "아파트관리사무소", "생활관", "서점", "도서관", "급식실", "휴대폰대리점", "주유소", "공원", "에버랜드", "롯데월드", "지하철역", "시내버스", "고속버스", "중화반점", "동대문시장", "맘스터치", "맥도날드", "롯데리아", "우정사업본부", "길고양이급식소", "휴지통속", "반찬가게", "동물원", "동물병원", "왁싱샵", "노인복지관", "공중화장실", "설빙", "배스킨라빈스", "피자헛", "맘스터치", "피자스쿨", "게이바", "보쌈집", "룸싸롱"};
    private static String[] killingTogether = {"친구와 함께", "친구들과 함께", "혼자서", "나홀로", "친구와", "애완동물과 함께"};
    private static String[] killingWhat = {"성교하다", "자위하다", "사정을 하다", "밥을 먹다", "똥을 싸다", "오줌을 누다", "잠을 자다", "난동을 부리다", "운동을 하다", "걷다가", "뛰다가", "팔굽혀펴기를 하다", "울다가", "웃다가", "거울을 보다", "기어다니다", "냄새를 맡다", "휴대폰을 만지다", "도촬을 하다", "돈을 세다", "자해를 하다", "고추를 만지다", "졸다", "옷을 벗다", "옷을 입다", "만화를 보다", "드라마를 보다", "영화를 보다", "책을 읽다", "샤워하다", "누워있다", "청소하다", "약탈을 하다", "도둑질을 하다", "물건을 훔치다", "아이스크림을 먹다", "돈을 세다", "구경을 하다"};
    private static String[] killingWhy = {"감전되어", "심장마비로", "에이즈에 걸려", "너무 피곤하여", "자연스럽게", "늙어서", "뒤로 넘어져", "앞으로 고꾸라져", "떨어져서", "교통사고로", "추락하여", "폭발하여", "저체온증으로", "추워서", "더워서", "칼을 맞아", "습격을 받아", "총을 맞아", "수류탄에", "맞아서", "집단구타로", "불에 타서", "질식해서", "물에 빠져", "무언가 목에 걸려", "배고파서", "굶어서", "많이 먹어서", "피를 너무 많이 흘려", "치매에 걸려", "모기에 물려", "감기에 걸려", "독감으로", "식중독으로", "성병으로", "치질으로", "우울해져", "정신병에 걸려", "미쳐버려", "레고를 밟고", "실성해서", "탈진해서", "자살기도로", "심심해서", "뜬금없이", "의문스럽게", "숨 쉬는걸 까먹어", "바나나껍질을 발고 미끄러져", "복상사로", "자기도 모르게", "스트레스로", "차에 치어", "중독되어", "장염에 걸려", "코로나에 걸려", "조선족의 습격을 받고", "기뻐하다", "집단구타를 맞고", "밟혀"};
    private static String[] killingFinal = {"뒤진다.", "죽는다.", "디진다.", "죽을 것이다.", "뒈진다.", "죽어버린다.", "죽게된다.", "죽음에 이르게 된다.", "사망한다.", "즉사한다.", "쇼크사 한다."};

    // 죽어
    public static void Make(MessageReceivedEvent event, String name) {

        String result = "";

        Random rand = new Random();

        if(rand.nextInt(10) > 4)
            result += Util.randomArray(killingWhen) + " ";
        if(rand.nextInt(10) > 2)
            result += Util.randomArray(killingWhere) + "에서 ";
        if(rand.nextInt(10) > 7)
            result += Util.randomArray(killingTogether) + " ";
        if(rand.nextInt(10) > 2)
            result += Util.randomArray(killingWhat) + " ";
        if(rand.nextInt(10) > 2)
            result += Util.randomArray(killingWhy) + " ";

        event.getChannel().sendMessage(":skull_crossbones:  " + Util.josa(name, "은", "는") + " " + result + Util.randomArray(killingFinal)).queue();
    }
}
