package com.example.quizmatic.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.quizmatic.model.Questions;
import com.example.quizmatic.db.QuizContract.*;

import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "Quizmatic.db";
    private static final int DATABASE_VERSION = 10;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context)
    {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionTable.COLUMN_CATEGORY + " TEXT, " +
                QuestionTable.COLUMN_LEVELS_ID + " INTEGER " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable()
    {
        Questions s1 = new Questions("Aşağıda verilen Mısır piramidlerinden hangisi en büyüktür?","Mikerinos Piramidi","Sfenks Piramidi","Keops Piramidi","Kefren Piramidi",3,Questions.CATEGORY_GENERAL_CULTURE,Questions.LEVEL1);
        addQuestions(s1);

        Questions s2 = new Questions("Aşağıdaki ülkelerden hangisinin birden fazla başkenti vardır?","Kanada","Güney Afrika","Tanzanya","Vietnam",2,Questions.CATEGORY_GENERAL_CULTURE,Questions.LEVEL1);
        addQuestions(s2);

        Questions s3 = new Questions("Hangi kıtanın nüfusu diğerlerine göre daha azdır?","Avrupa","Asya","Kuzey Amerika","Güney Amerika",4,Questions.CATEGORY_GENERAL_CULTURE,Questions.LEVEL1);
        addQuestions(s3);

        Questions s4 = new Questions("Aşağıdaki ülkelerden hangisinin yüzölçümü diğerlerine göre daha büyüktür?","Türkiye","Fransa","Meksika","Moğolistan",3,Questions.CATEGORY_GENERAL_CULTURE,Questions.LEVEL2);
        addQuestions(s4);

        Questions s5 = new Questions("Türklerin İslamiyetten önceki dini hangisidir?","Tengricilik","Şintoizm","Hinduizm","Zerdüştçülük",1,Questions.CATEGORY_GENERAL_CULTURE,Questions.LEVEL2);
        addQuestions(s5);

        Questions s6 = new Questions("Türk Edebiyatı tarihinde ilk edebi roman olarak kabul edilen ''İntibah'' kimin eseridir?","Tevfik Fikret","Namık Kemal","Recaizade Mahmud Ekrem","Yahya Kemal Beyatlı",2,Questions.CATEGORY_GENERAL_CULTURE,Questions.LEVEL2);
        addQuestions(s6);

        Questions s7 = new Questions("Kükürt elementinin simgesi nedir?","C","Cl","S","K",3,Questions.CATEGORY_GENERAL_CULTURE,Questions.LEVEL2);
        addQuestions(s7);

        Questions s8 = new Questions("Osmanlıyı en çok toprak kaybına uğratan padişah aşağıdakilerden hangisidir?","II. Abdülhamid","Sultan Vahdettin","V.Mehmet","Sultan Abdülmecid",1,Questions.CATEGORY_GENERAL_CULTURE,Questions.LEVEL3);
        addQuestions(s8);

        Questions s9 = new Questions("Aşağıdakilerden hangisi Fransız Devrimi yazarı değildir?","Jean Jacques Rousseau","Denis Diderot","Voltaire","Maximilien Robespierre",4,Questions.CATEGORY_GENERAL_CULTURE,Questions.LEVEL3);
        addQuestions(s9);

        Questions s10 = new Questions("Kuzey ışıkları aşağıdaki ülkelerden hangisinde görülemez?","Norveç","Kanada","Danimarka","Finlandiya",3,Questions.CATEGORY_GENERAL_CULTURE,Questions.LEVEL3);
        addQuestions(s10);

        Questions s57 = new Questions("Dünyanın En Derin Mağarasının Uzunluğudur Kaç Metredir?","2445","2212","2432","2245",2,Questions.CATEGORY_GENERAL_CULTURE,Questions.LEVEL3);
        addQuestions(s57);

        Questions s58 = new Questions("Aşağıdakilerden hangisi Avrupa'nın En Aktif Yanardağıdır?","Katla Volcano","Vezüv Yanardağı","Hekla","Etna Yanardağı",4,Questions.CATEGORY_GENERAL_CULTURE,Questions.LEVEL3);
        addQuestions(s58);

        //

        Questions s11 = new Questions("Aşağıdakilerden hangisi Türk Edebiyatında Doğal Destan değildir?","Yaradılış Destanı","Alp Er Tunga Destanı","Genç Osman Destanı","Göç Destanları",3,Questions.CATEGORY_LITERATURE,Questions.LEVEL1);
        addQuestions(s11);

        Questions s12 = new Questions("Aşağıdakilerden hangisi Türk Destanlarının Motifleri arasında bulunmaz?","Işık","Koyun","At","Ak Sakallı İhtiyar",2,Questions.CATEGORY_LITERATURE,Questions.LEVEL1);
        addQuestions(s12);

        Questions s13 = new Questions("Aşağıdakilerden hangisi Halide Edip Adıvar'ın eserlerinden biri değildir?","Handan","Sinekli Bakkal","Vurun Kahpeye","Cezmi",4,Questions.CATEGORY_LITERATURE,Questions.LEVEL1);
        addQuestions(s13);

        Questions s14 = new Questions("Aşağıdakilerden hangisi habercilikle ilgili bir terim değildir?","Asparagas","Sansasyonel","Meddahlık","Tekzip",3,Questions.CATEGORY_LITERATURE,Questions.LEVEL2);
        addQuestions(s14);

        Questions s15 = new Questions("Aşağıdakilerden hangisi Orta Oyunu'nun bölümlerinden biri değildir?","İlerleme","Giriş","Muhavere","Fasıl",1,Questions.CATEGORY_LITERATURE,Questions.LEVEL2);
        addQuestions(s15);

        Questions s16 = new Questions("Türk Edebiyatında Sergüzeşt hangi yazarımıza aittir?","Halde Edip Adıvar","Samipaşazade Sezai","Recaizade Mahmud Ekrem","Yahya Kemal Beyatlı",2,Questions.CATEGORY_LITERATURE,Questions.LEVEL2);
        addQuestions(s16);

        Questions s17 = new Questions("Aşağıdaki sanatçılardan hangisinin gezi yazısı türünde eseri yoktur?","Tevfik Fikret","Atilla İlhan","Mina Urgan","Ahmet Mithat Efendi",1,Questions.CATEGORY_LITERATURE,Questions.LEVEL2);
        addQuestions(s17);

        Questions s18 = new Questions("Aşağıdaki eserlerden hangisi gezi yazısı türünde yazılmıştır?","Yolcu Defteri","Saray ve Ötesi","Taaşşuk-ı Talat ve fitnat","Aşk-ı Memnu",1,Questions.CATEGORY_LITERATURE,Questions.LEVEL3);
        addQuestions(s18);

        Questions s19 = new Questions("Aşağıdakilerden hangisi haber yazısında bulunması gereken niteliklerden biri değildir?","Gerçeklik","Doğruluk","Nesnellik","Bilimsellik",4,Questions.CATEGORY_LITERATURE,Questions.LEVEL3);
        addQuestions(s19);

        Questions s20 = new Questions("Aşağıdakilerden hangisi Dede Korkut'un özelliklerinden biri değildir?","Eser bir önsöz ile 12 hikayeden oluşur.","Dede Korkut, meçhul bir halk ozanıdır.","17.yy'da yazıya geçirilmiştir.","Eserin yazarı belli değildir.",3,Questions.CATEGORY_LITERATURE,Questions.LEVEL3);
        addQuestions(s20);

        Questions s53 = new Questions("Aşağıdakilerden Hangisi Tarihin İlk Yazılı Antlaşmasıdır?","Verdun Antlaşması","Kadeş Antlaşması","İli Nehri Antlaşması","Kallias Barışı",2,Questions.CATEGORY_LITERATURE,Questions.LEVEL3);
        addQuestions(s53);

        Questions s54 = new Questions("Aşağıdakilerden Hangisi Bilinen İlk Türk Şairdir?","Arpın Çor Tigin","Ali Şîr Nevaî","Molla Câmî","Nizami Gencevi",1,Questions.CATEGORY_LITERATURE,Questions.LEVEL3);
        addQuestions(s54);

        //

        Questions s21 = new Questions("Futbolu hangi medeniyet bulmuştur?","İngilizler","Çinliler","Almanlar","Apaçiler",2,Questions.CATEGORY_SPORT,Questions.LEVEL1);
        addQuestions(s21);

        Questions s22 = new Questions("NBA'da en çok sayı kaydeden oyuncu kimdir?","Karl Malone","Micheal Jordan","Kareem Abdul Jabbar","Dirk Nowitzki",3,Questions.CATEGORY_SPORT,Questions.LEVEL1);
        addQuestions(s22);

        Questions s23 = new Questions("Voleybolda takım arkadaşlarına nazaran kısa olan kişiye verilen ad nedir?","Pasör Çaprazı","Smaçör","Pasör","Libero",4,Questions.CATEGORY_SPORT,Questions.LEVEL1);
        addQuestions(s23);

        Questions s24 = new Questions("Türkiye liginde 1959'dan sonra bir sezonda en çok gol atan oyuncu kimdir?","Tanju Çolak","Metin Oktay","Lefter Küçükandonyadis","Hakan Şükür",1,Questions.CATEGORY_SPORT,Questions.LEVEL2);
        addQuestions(s24);

        Questions s25 = new Questions("Olimpiyatlarda en çok madalya kazanan sporcu kimdir?","Michael Phelps","Larissa Latynina","Paul Elvström","Nikolai Andrianov",1,Questions.CATEGORY_SPORT,Questions.LEVEL2);
        addQuestions(s25);

        Questions s26 = new Questions("Tenis tarihinde en çok Grand Slam kazanan tenisci kimdir?","Pete Sampras","Rafael Nadal","Roger Federer","Novak Djokovic",3,Questions.CATEGORY_SPORT,Questions.LEVEL2);
        addQuestions(s26);

        Questions s27 = new Questions("Basketbol tarihinde bir maçta en çok sayı atan oyuncu kimdir?","Kobe Bryant","James Harden","Micheal Jordan","Lebron James",1,Questions.CATEGORY_SPORT,Questions.LEVEL2);
        addQuestions(s27);

        Questions s28 = new Questions("En çok Şampiyonlar Ligi kazanan takım?","Milan","Barcelona","Liverpool","Real Madrid",4,Questions.CATEGORY_SPORT,Questions.LEVEL3);
        addQuestions(s28);

        Questions s29 = new Questions("NBA'da en çok şampiyon takımdır?","Los Angeles Lakers","Boston Celtics","Chicago Bulls","Golden State Warriors",2,Questions.CATEGORY_SPORT,Questions.LEVEL3);
        addQuestions(s29);

        Questions s30 = new Questions("Futbolda en çok gol atan oyuncu kimdir?","Cristiano Ronaldo","Lionel Messi","Josef Bican","Pele",3,Questions.CATEGORY_SPORT,Questions.LEVEL3);
        addQuestions(s30);

        Questions s51 = new Questions("Aşağıdakilerden hangisi İlk Kadın Maraton Koşucusudur?","Kathrine Switzer","Marita Koch","Marlies Göhr","Renate Stecher",1,Questions.CATEGORY_SPORT,Questions.LEVEL3);
        addQuestions(s51);

        Questions s52 = new Questions("Aşağıdakilerden hangisi FIFA Kokartlı İlk Türk Hakemdir?","Cüneyt Çakır","Erman Toroğlu","Sulhi Garan ","Hilmi Ok",3,Questions.CATEGORY_SPORT,Questions.LEVEL3);
        addQuestions(s52);


        //

        Questions s31 = new Questions("Aşağıdakilerden hangisi simyacıların kullandığı tekniklerden biri değildir?","Yakma","Damıtma","Fırınlama","Kesme",4,Questions.CATEGORY_SCIENCE,Questions.LEVEL1);
        addQuestions(s31);

        Questions s32 = new Questions("Aşağıdakilerden hangisi Newton'un kafasına düşmüştür?","Ceviz","Elma","Armut","Kozalak",2,Questions.CATEGORY_SCIENCE,Questions.LEVEL1);
        addQuestions(s32);

        Questions s33 = new Questions("Aşağıdakilerden hangisinin kalp odası sayısı diğerlerinden farklıdır?","Karınca","Salyangoz","Dinazor","Timsah",4,Questions.CATEGORY_SCIENCE,Questions.LEVEL1);
        addQuestions(s33);

        Questions s34 = new Questions("Periyodik tabloda kaç stun vardır?","32","22","34","28",1,Questions.CATEGORY_SCIENCE,Questions.LEVEL2);
        addQuestions(s34);

        Questions s35 = new Questions("Bir saç teli günde kaç mm uzar?","0.30mm","0.35mm","0.40mm","0.45mm",2,Questions.CATEGORY_SCIENCE,Questions.LEVEL2);
        addQuestions(s35);

        Questions s36 = new Questions("Kan tüm vücudu kaç saniyede dolaşır?","21-22","23-24","24-25","22-23",4,Questions.CATEGORY_SCIENCE,Questions.LEVEL2);
        addQuestions(s36);

        Questions s37 = new Questions("Aşağıdaki hastalıklardan hangisi genetiktir?","Kabakulak","Hemoglobin","Su Çiçeğİ","Corona",2,Questions.CATEGORY_SCIENCE,Questions.LEVEL2);
        addQuestions(s37);

        Questions s38 = new Questions("Genel verici olarak adlandırılan kan grubu hangisidir?","B Rh-","AB Rh-","A Rh+","0 Rh-",4,Questions.CATEGORY_SCIENCE,Questions.LEVEL3);
        addQuestions(s38);

        Questions s39 = new Questions("İnsanların kromozom sayısı kaçtır?","42","44","46","48",3,Questions.CATEGORY_SCIENCE,Questions.LEVEL3);
        addQuestions(s39);

        Questions s40 = new Questions("Graham Bell telefonu bulduktan sonra ilk kiminle konuşmuştur?","Komşusu ile","Başbakan ile","Karısı ile","Kızı ile",3,Questions.CATEGORY_SCIENCE,Questions.LEVEL3);
        addQuestions(s40);

        Questions s55 = new Questions("Aşağıdakilerden Hangisi İlk İnsanlı Uzay Aracıdır?","Sputnik 1","Voyager 1","Luna 1","Vostok 1",4,Questions.CATEGORY_SCIENCE,Questions.LEVEL3);
        addQuestions(s55);

        Questions s56 = new Questions("Aşağıdakilerden Hangisi İlk Kadın Psikologdur?","Margaret Floy Washburn","Karen Horney","Mary Ainsworth","Mary Whiton Calkins",1,Questions.CATEGORY_SCIENCE,Questions.LEVEL3);
        addQuestions(s56);

        //

        Questions s41 = new Questions("2/5'i 80 olan sayının 1/5'i kaçtır??","20","40","60","80",2,Questions.CATEGORY_MATH,Questions.LEVEL1);
        addQuestions(s41);

        Questions s42 = new Questions("Çevresi 24 cm olan karenin bir kenarı kaç cm'dir?","10cm","6cm","8cm","12cm",2,Questions.CATEGORY_MATH,Questions.LEVEL1);
        addQuestions(s42);

        Questions s43 = new Questions("56 saat kaç dakikadır?","3636","4360","3280","3360",4,Questions.CATEGORY_MATH,Questions.LEVEL1);
        addQuestions(s43);

        Questions s44 = new Questions("12 > A > 7 ise A yerine yazılabilecek sayıların toplamı kaçtır?","39","27","38","28",3,Questions.CATEGORY_MATH,Questions.LEVEL2);
        addQuestions(s44);

        Questions s45 = new Questions("Sema 1. sınavdan 60, 2. sınavdan 80, 3. sınavdan da 92 almıştır. O halde sene sonu ortalaması kaçtır?","77,3","67,3","77,6","67,6",1,Questions.CATEGORY_MATH,Questions.LEVEL2);
        addQuestions(s45);

        Questions s46 = new Questions("1=4 , 2=16 , 3=64 , 4=?","128","256","328","80",2,Questions.CATEGORY_MATH,Questions.LEVEL2);
        addQuestions(s46);

        Questions s47 = new Questions("12*12=9 , 23*23=16 , 34*34=?","13","24","32","18",1,Questions.CATEGORY_MATH,Questions.LEVEL2);
        addQuestions(s47);

        Questions s48 = new Questions("A+B=76 , A-B=38 ,   A/B=?","3","5","7","9",1,Questions.CATEGORY_MATH,Questions.LEVEL3);
        addQuestions(s48);

        Questions s49 = new Questions("Aşağıdakilerden hangisi bir asal sayı değildir?","101","97","89","91",4,Questions.CATEGORY_MATH,Questions.LEVEL3);
        addQuestions(s49);

        Questions s50 = new Questions("Şubat ayındaysak ve bugün, saat 09.58’de kar yağıyorsa, 86 saat sonra havanın güneşli olma ihtimali % kaçtır?","%25","%0","%50","%100",3,Questions.CATEGORY_MATH,Questions.LEVEL3);
        addQuestions(s50);

        Questions s59 = new Questions("8/2(2+2)?","1","2","4","16",1,Questions.CATEGORY_MATH,Questions.LEVEL3);
        addQuestions(s59);

        Questions s60 = new Questions("Aşağıdakilerden hangisi daha büyüktür?","1/2","2/3","3/4","5/6",4,Questions.CATEGORY_MATH,Questions.LEVEL3);
        addQuestions(s60);

    }

    private void addQuestions(Questions question)
    {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        cv.put(QuestionTable.COLUMN_CATEGORY,question.getCategory());
        cv.put(QuestionTable.COLUMN_LEVELS_ID,question.getLevels());

        db.insert(QuestionTable.TABLE_NAME,null,cv);

    }

    public ArrayList<Questions> getAllQuestions()
    {
        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR
        };

        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                null,
                null,
                null,
                null,
                null);

        if (c.moveToFirst())
        {
            do {

                Questions question = new Questions();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
        }

    public ArrayList<Questions> getAllQuestionsWithCategory(String category)
    {
        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_CATEGORY
        };

        String selection = QuestionTable.COLUMN_CATEGORY + " = ? ";
        String selectionArgs[] = {category};

        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                selection,
                selectionArgs,
                null,
                null,
                null);


        if (c.moveToFirst())
        {
            do {

                Questions question = new Questions();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }

    public ArrayList<Questions> getAllQuestionsWithCategoryAndLevels(int levelsID,String category)
    {
        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String Projection[] = {
                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_CATEGORY,
                QuestionTable.COLUMN_LEVELS_ID
        };

        String selection = QuestionTable.COLUMN_LEVELS_ID + " = ? " +
                " AND " + QuestionTable.COLUMN_CATEGORY + " = ? ";

        String selectionArgs[] = {String.valueOf(levelsID),category};

        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                selection,
                selectionArgs,
                null,
                null,
                null);

        if (c.moveToFirst())
        {
            do {

                Questions question = new Questions();
                question.setId(c.getInt(c.getColumnIndex(QuestionTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));
                question.setLevels(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_LEVELS_ID)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }
}