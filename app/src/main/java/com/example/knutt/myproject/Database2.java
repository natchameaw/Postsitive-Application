package com.example.knutt.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by KNUTT on 7/2/2561.
 */

public class Database2 extends SQLiteOpenHelper{

    private static final int dbVersion = 1;
    private static final String dbName = "databaseword2.sqlite";

    private static final String tableName4 = "Attitudetable2";
    private static final String col2Antitude1 = "AttitudeID";
    private static final String col2Antitude2 = "AttitudeWord";
    private static final String col2Antitude3 = "AttitudeRank";
    private static final String col2Antitude4 = "Emotion";

    public Database2(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+tableName4+"("+col2Antitude1+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                col2Antitude2+" TEXT,"+col2Antitude3+" INTEGER,"+col2Antitude4+" TEXT)");

        ContentValues attvalue501 = new ContentValues();
        ContentValues attvalue502 = new ContentValues();
        ContentValues attvalue503 = new ContentValues();
        ContentValues attvalue504 = new ContentValues();
        ContentValues attvalue505 = new ContentValues();
        ContentValues attvalue506 = new ContentValues();
        ContentValues attvalue507 = new ContentValues();
        ContentValues attvalue508 = new ContentValues();
        ContentValues attvalue509 = new ContentValues();
        ContentValues attvalue510 = new ContentValues();
        ContentValues attvalue511 = new ContentValues();
        ContentValues attvalue512 = new ContentValues();
        ContentValues attvalue513 = new ContentValues();
        ContentValues attvalue514 = new ContentValues();
        ContentValues attvalue515 = new ContentValues();
        ContentValues attvalue516 = new ContentValues();
        ContentValues attvalue517 = new ContentValues();
        ContentValues attvalue518 = new ContentValues();
        ContentValues attvalue519 = new ContentValues();
        ContentValues attvalue520 = new ContentValues();
        ContentValues attvalue521 = new ContentValues();
        ContentValues attvalue522 = new ContentValues();
        ContentValues attvalue523 = new ContentValues();
        ContentValues attvalue524 = new ContentValues();
        ContentValues attvalue525 = new ContentValues();
        ContentValues attvalue526 = new ContentValues();
        ContentValues attvalue527 = new ContentValues();
        ContentValues attvalue528 = new ContentValues();
        ContentValues attvalue529 = new ContentValues();
        ContentValues attvalue530 = new ContentValues();
        ContentValues attvalue531 = new ContentValues();
        ContentValues attvalue532 = new ContentValues();
        ContentValues attvalue533 = new ContentValues();
        ContentValues attvalue534 = new ContentValues();
        ContentValues attvalue535 = new ContentValues();
        ContentValues attvalue536 = new ContentValues();
        ContentValues attvalue537 = new ContentValues();
        ContentValues attvalue538 = new ContentValues();
        ContentValues attvalue539 = new ContentValues();
        ContentValues attvalue540 = new ContentValues();
        ContentValues attvalue541 = new ContentValues();
        ContentValues attvalue542 = new ContentValues();
        ContentValues attvalue543 = new ContentValues();
        ContentValues attvalue544 = new ContentValues();
        ContentValues attvalue545 = new ContentValues();
        ContentValues attvalue546 = new ContentValues();
        ContentValues attvalue547 = new ContentValues();
        ContentValues attvalue548 = new ContentValues();
        ContentValues attvalue549 = new ContentValues();
        ContentValues attvalue550 = new ContentValues();
        ContentValues attvalue551 = new ContentValues();
        ContentValues attvalue552 = new ContentValues();
        ContentValues attvalue553 = new ContentValues();
        ContentValues attvalue554 = new ContentValues();
        ContentValues attvalue555 = new ContentValues();
        ContentValues attvalue556 = new ContentValues();
        ContentValues attvalue557 = new ContentValues();
        ContentValues attvalue558 = new ContentValues();
        ContentValues attvalue559 = new ContentValues();
        ContentValues attvalue560 = new ContentValues();
        ContentValues attvalue561 = new ContentValues();
        ContentValues attvalue562 = new ContentValues();
        ContentValues attvalue563 = new ContentValues();
        ContentValues attvalue564 = new ContentValues();
        ContentValues attvalue565 = new ContentValues();
        ContentValues attvalue566 = new ContentValues();
        ContentValues attvalue567 = new ContentValues();
        ContentValues attvalue568 = new ContentValues();
        ContentValues attvalue569 = new ContentValues();
        ContentValues attvalue570 = new ContentValues();
        ContentValues attvalue571 = new ContentValues();
        ContentValues attvalue572 = new ContentValues();
        ContentValues attvalue573 = new ContentValues();
        ContentValues attvalue574 = new ContentValues();
        ContentValues attvalue575 = new ContentValues();
        ContentValues attvalue576 = new ContentValues();
        ContentValues attvalue577 = new ContentValues();
        ContentValues attvalue578 = new ContentValues();
        ContentValues attvalue579 = new ContentValues();
        ContentValues attvalue580 = new ContentValues();
        ContentValues attvalue581 = new ContentValues();
        ContentValues attvalue582 = new ContentValues();
        ContentValues attvalue583 = new ContentValues();
        ContentValues attvalue584 = new ContentValues();
        ContentValues attvalue585 = new ContentValues();
        ContentValues attvalue586 = new ContentValues();
        ContentValues attvalue587 = new ContentValues();
        ContentValues attvalue588 = new ContentValues();
        ContentValues attvalue589 = new ContentValues();
        ContentValues attvalue590 = new ContentValues();
        ContentValues attvalue591 = new ContentValues();
        ContentValues attvalue592 = new ContentValues();
        ContentValues attvalue593 = new ContentValues();
        ContentValues attvalue594 = new ContentValues();
        ContentValues attvalue595 = new ContentValues();
        ContentValues attvalue596 = new ContentValues();
        ContentValues attvalue597 = new ContentValues();
        ContentValues attvalue598 = new ContentValues();
        ContentValues attvalue599 = new ContentValues();
        ContentValues attvalue600 = new ContentValues();
        ContentValues attvalue601 = new ContentValues();
        ContentValues attvalue602 = new ContentValues();
        ContentValues attvalue603 = new ContentValues();
        ContentValues attvalue604 = new ContentValues();
        ContentValues attvalue605 = new ContentValues();
        ContentValues attvalue606 = new ContentValues();
        ContentValues attvalue607 = new ContentValues();
        ContentValues attvalue608 = new ContentValues();
        ContentValues attvalue609 = new ContentValues();
        ContentValues attvalue610 = new ContentValues();
        ContentValues attvalue611 = new ContentValues();
        ContentValues attvalue612 = new ContentValues();
        ContentValues attvalue613 = new ContentValues();
        ContentValues attvalue614 = new ContentValues();
        ContentValues attvalue615 = new ContentValues();
        ContentValues attvalue616 = new ContentValues();
        ContentValues attvalue617 = new ContentValues();
        ContentValues attvalue618 = new ContentValues();
        ContentValues attvalue619 = new ContentValues();
        ContentValues attvalue620 = new ContentValues();
        ContentValues attvalue621 = new ContentValues();
        ContentValues attvalue622 = new ContentValues();
        ContentValues attvalue623 = new ContentValues();
        ContentValues attvalue624 = new ContentValues();
        ContentValues attvalue625 = new ContentValues();
        ContentValues attvalue626 = new ContentValues();
        ContentValues attvalue627 = new ContentValues();
        ContentValues attvalue628 = new ContentValues();
        ContentValues attvalue629 = new ContentValues();
        ContentValues attvalue630 = new ContentValues();
        ContentValues attvalue631 = new ContentValues();
        ContentValues attvalue632 = new ContentValues();
        ContentValues attvalue633 = new ContentValues();
        ContentValues attvalue634 = new ContentValues();
        ContentValues attvalue635 = new ContentValues();
        ContentValues attvalue636 = new ContentValues();
        ContentValues attvalue637 = new ContentValues();
        ContentValues attvalue638 = new ContentValues();
        ContentValues attvalue639 = new ContentValues();
        ContentValues attvalue640 = new ContentValues();
        ContentValues attvalue641 = new ContentValues();
        ContentValues attvalue642 = new ContentValues();
        ContentValues attvalue643 = new ContentValues();
        ContentValues attvalue644 = new ContentValues();
        ContentValues attvalue645 = new ContentValues();
        ContentValues attvalue646 = new ContentValues();
        ContentValues attvalue647 = new ContentValues();
        ContentValues attvalue648 = new ContentValues();
        ContentValues attvalue649 = new ContentValues();
        ContentValues attvalue650 = new ContentValues();
        ContentValues attvalue651 = new ContentValues();
        ContentValues attvalue652 = new ContentValues();
        ContentValues attvalue653 = new ContentValues();
        ContentValues attvalue654 = new ContentValues();
        ContentValues attvalue655 = new ContentValues();
        ContentValues attvalue656 = new ContentValues();
        ContentValues attvalue657 = new ContentValues();
        ContentValues attvalue658 = new ContentValues();
        ContentValues attvalue659 = new ContentValues();
        ContentValues attvalue660 = new ContentValues();
        ContentValues attvalue661 = new ContentValues();
        ContentValues attvalue662 = new ContentValues();
        ContentValues attvalue663 = new ContentValues();
        ContentValues attvalue664 = new ContentValues();
        ContentValues attvalue665 = new ContentValues();
        ContentValues attvalue666 = new ContentValues();
        ContentValues attvalue667 = new ContentValues();
        ContentValues attvalue668 = new ContentValues();
        ContentValues attvalue669 = new ContentValues();
        ContentValues attvalue670 = new ContentValues();
        ContentValues attvalue671 = new ContentValues();
        ContentValues attvalue672 = new ContentValues();
        ContentValues attvalue673 = new ContentValues();
        ContentValues attvalue674 = new ContentValues();
        ContentValues attvalue675 = new ContentValues();
        ContentValues attvalue676 = new ContentValues();
        ContentValues attvalue677 = new ContentValues();
        ContentValues attvalue678 = new ContentValues();
        ContentValues attvalue679 = new ContentValues();
        ContentValues attvalue680 = new ContentValues();
        ContentValues attvalue681 = new ContentValues();
        ContentValues attvalue682 = new ContentValues();
        ContentValues attvalue683 = new ContentValues();
        ContentValues attvalue684 = new ContentValues();
        ContentValues attvalue685 = new ContentValues();
        ContentValues attvalue686 = new ContentValues();
        ContentValues attvalue687 = new ContentValues();
        ContentValues attvalue688 = new ContentValues();
        ContentValues attvalue689 = new ContentValues();
        ContentValues attvalue690 = new ContentValues();
        ContentValues attvalue691 = new ContentValues();
        ContentValues attvalue692 = new ContentValues();
        ContentValues attvalue693 = new ContentValues();
        ContentValues attvalue694 = new ContentValues();
        ContentValues attvalue695 = new ContentValues();
        ContentValues attvalue696 = new ContentValues();
        ContentValues attvalue697 = new ContentValues();
        ContentValues attvalue698 = new ContentValues();
        ContentValues attvalue699 = new ContentValues();
        ContentValues attvalue700 = new ContentValues();
        ContentValues attvalue701 = new ContentValues();
        ContentValues attvalue702 = new ContentValues();
        ContentValues attvalue703 = new ContentValues();
        ContentValues attvalue704 = new ContentValues();
        ContentValues attvalue705 = new ContentValues();
        ContentValues attvalue706 = new ContentValues();
        ContentValues attvalue707 = new ContentValues();
        ContentValues attvalue708 = new ContentValues();
        ContentValues attvalue709 = new ContentValues();
        ContentValues attvalue710 = new ContentValues();
        ContentValues attvalue711 = new ContentValues();
        ContentValues attvalue712 = new ContentValues();
        ContentValues attvalue713 = new ContentValues();
        ContentValues attvalue714 = new ContentValues();
        ContentValues attvalue715 = new ContentValues();
        ContentValues attvalue716 = new ContentValues();
        ContentValues attvalue717 = new ContentValues();
        ContentValues attvalue718 = new ContentValues();
        ContentValues attvalue719 = new ContentValues();
        ContentValues attvalue720 = new ContentValues();
        ContentValues attvalue721 = new ContentValues();
        ContentValues attvalue722 = new ContentValues();
        ContentValues attvalue723 = new ContentValues();
        ContentValues attvalue724 = new ContentValues();
        ContentValues attvalue725 = new ContentValues();
        ContentValues attvalue726 = new ContentValues();
        ContentValues attvalue727 = new ContentValues();
        ContentValues attvalue728 = new ContentValues();
        ContentValues attvalue729 = new ContentValues();
        ContentValues attvalue730 = new ContentValues();
        ContentValues attvalue731 = new ContentValues();
        ContentValues attvalue732 = new ContentValues();
        ContentValues attvalue733 = new ContentValues();
        ContentValues attvalue734 = new ContentValues();
        ContentValues attvalue735 = new ContentValues();
        ContentValues attvalue736 = new ContentValues();
        ContentValues attvalue737 = new ContentValues();
        ContentValues attvalue738 = new ContentValues();
        ContentValues attvalue739 = new ContentValues();
        ContentValues attvalue740 = new ContentValues();
        ContentValues attvalue741 = new ContentValues();
        ContentValues attvalue742 = new ContentValues();
        ContentValues attvalue743 = new ContentValues();
        ContentValues attvalue744 = new ContentValues();
        ContentValues attvalue745 = new ContentValues();
        ContentValues attvalue746 = new ContentValues();
        ContentValues attvalue747 = new ContentValues();
        ContentValues attvalue748 = new ContentValues();
        ContentValues attvalue749 = new ContentValues();
        ContentValues attvalue750 = new ContentValues();
        ContentValues attvalue751 = new ContentValues();
        ContentValues attvalue752 = new ContentValues();
        ContentValues attvalue753 = new ContentValues();
        ContentValues attvalue754 = new ContentValues();
        ContentValues attvalue755 = new ContentValues();
        ContentValues attvalue756 = new ContentValues();
        ContentValues attvalue757 = new ContentValues();
        ContentValues attvalue758 = new ContentValues();
        ContentValues attvalue759 = new ContentValues();
        ContentValues attvalue760 = new ContentValues();
        ContentValues attvalue761 = new ContentValues();
        ContentValues attvalue762 = new ContentValues();
        ContentValues attvalue763 = new ContentValues();
        ContentValues attvalue764 = new ContentValues();
        ContentValues attvalue765 = new ContentValues();
        ContentValues attvalue766 = new ContentValues();
        ContentValues attvalue767 = new ContentValues();
        ContentValues attvalue768 = new ContentValues();
        ContentValues attvalue769 = new ContentValues();
        ContentValues attvalue770 = new ContentValues();
        ContentValues attvalue771 = new ContentValues();
        ContentValues attvalue772 = new ContentValues();
        ContentValues attvalue773 = new ContentValues();
        ContentValues attvalue774 = new ContentValues();
        ContentValues attvalue775 = new ContentValues();
        ContentValues attvalue776 = new ContentValues();
        ContentValues attvalue777 = new ContentValues();
        ContentValues attvalue778 = new ContentValues();
        ContentValues attvalue779 = new ContentValues();
        ContentValues attvalue780 = new ContentValues();
        ContentValues attvalue781 = new ContentValues();
        ContentValues attvalue782 = new ContentValues();
        ContentValues attvalue783 = new ContentValues();
        ContentValues attvalue784 = new ContentValues();
        ContentValues attvalue785 = new ContentValues();
        ContentValues attvalue786 = new ContentValues();
        ContentValues attvalue787 = new ContentValues();
        ContentValues attvalue788 = new ContentValues();
        ContentValues attvalue789 = new ContentValues();
        ContentValues attvalue790 = new ContentValues();
        ContentValues attvalue791 = new ContentValues();
        ContentValues attvalue792 = new ContentValues();
        ContentValues attvalue793 = new ContentValues();
        ContentValues attvalue794 = new ContentValues();
        ContentValues attvalue795 = new ContentValues();
        ContentValues attvalue796 = new ContentValues();
        ContentValues attvalue797 = new ContentValues();
        ContentValues attvalue798 = new ContentValues();
        ContentValues attvalue799 = new ContentValues();
        ContentValues attvalue800 = new ContentValues();
        ContentValues attvalue801 = new ContentValues();
        ContentValues attvalue802 = new ContentValues();
        ContentValues attvalue803 = new ContentValues();
        ContentValues attvalue804 = new ContentValues();
        ContentValues attvalue805 = new ContentValues();
        ContentValues attvalue806 = new ContentValues();
        ContentValues attvalue807 = new ContentValues();
        ContentValues attvalue808 = new ContentValues();
        ContentValues attvalue809 = new ContentValues();
        ContentValues attvalue810 = new ContentValues();
        ContentValues attvalue811 = new ContentValues();
        ContentValues attvalue812 = new ContentValues();
        ContentValues attvalue813 = new ContentValues();
        ContentValues attvalue814 = new ContentValues();
        ContentValues attvalue815 = new ContentValues();
        ContentValues attvalue816 = new ContentValues();
        ContentValues attvalue817 = new ContentValues();
        ContentValues attvalue818 = new ContentValues();
        ContentValues attvalue819 = new ContentValues();
        ContentValues attvalue820 = new ContentValues();
        ContentValues attvalue821 = new ContentValues();
        ContentValues attvalue822 = new ContentValues();
        ContentValues attvalue823 = new ContentValues();
        ContentValues attvalue824 = new ContentValues();
        ContentValues attvalue825 = new ContentValues();
        ContentValues attvalue826 = new ContentValues();
        ContentValues attvalue827 = new ContentValues();
        ContentValues attvalue828 = new ContentValues();
        ContentValues attvalue829 = new ContentValues();
        ContentValues attvalue830 = new ContentValues();
        ContentValues attvalue831 = new ContentValues();
        ContentValues attvalue832 = new ContentValues();
        ContentValues attvalue833 = new ContentValues();
        ContentValues attvalue834 = new ContentValues();
        ContentValues attvalue835 = new ContentValues();
        ContentValues attvalue836 = new ContentValues();
        ContentValues attvalue837 = new ContentValues();
        ContentValues attvalue838 = new ContentValues();
        ContentValues attvalue839 = new ContentValues();
        ContentValues attvalue840 = new ContentValues();
        ContentValues attvalue841 = new ContentValues();
        ContentValues attvalue842 = new ContentValues();
        ContentValues attvalue843 = new ContentValues();
        ContentValues attvalue844 = new ContentValues();
        ContentValues attvalue845 = new ContentValues();
        ContentValues attvalue846 = new ContentValues();
        ContentValues attvalue847 = new ContentValues();
        ContentValues attvalue848 = new ContentValues();
        ContentValues attvalue849 = new ContentValues();
        ContentValues attvalue850 = new ContentValues();
        ContentValues attvalue851 = new ContentValues();
        ContentValues attvalue852 = new ContentValues();
        ContentValues attvalue853 = new ContentValues();
        ContentValues attvalue854 = new ContentValues();
        ContentValues attvalue855 = new ContentValues();
        ContentValues attvalue856 = new ContentValues();
        ContentValues attvalue857 = new ContentValues();
        ContentValues attvalue858 = new ContentValues();
        ContentValues attvalue859 = new ContentValues();
        ContentValues attvalue860 = new ContentValues();
        ContentValues attvalue861 = new ContentValues();
        ContentValues attvalue862 = new ContentValues();
        ContentValues attvalue863 = new ContentValues();
        ContentValues attvalue864 = new ContentValues();
        ContentValues attvalue865 = new ContentValues();
        ContentValues attvalue866 = new ContentValues();
        ContentValues attvalue867 = new ContentValues();
        ContentValues attvalue868 = new ContentValues();
        ContentValues attvalue869 = new ContentValues();
        ContentValues attvalue870 = new ContentValues();
        ContentValues attvalue871 = new ContentValues();
        ContentValues attvalue872 = new ContentValues();
        ContentValues attvalue873 = new ContentValues();
        ContentValues attvalue874 = new ContentValues();
        ContentValues attvalue875 = new ContentValues();
        ContentValues attvalue876 = new ContentValues();
        ContentValues attvalue877 = new ContentValues();
        ContentValues attvalue878 = new ContentValues();
        ContentValues attvalue879 = new ContentValues();
        ContentValues attvalue880 = new ContentValues();
        ContentValues attvalue881 = new ContentValues();
        ContentValues attvalue882 = new ContentValues();
        ContentValues attvalue883 = new ContentValues();
        ContentValues attvalue884 = new ContentValues();
        ContentValues attvalue885 = new ContentValues();
        ContentValues attvalue886 = new ContentValues();
        ContentValues attvalue887 = new ContentValues();
        ContentValues attvalue888 = new ContentValues();
        ContentValues attvalue889 = new ContentValues();
        ContentValues attvalue890 = new ContentValues();
        ContentValues attvalue891 = new ContentValues();
        ContentValues attvalue892 = new ContentValues();
        ContentValues attvalue893 = new ContentValues();
        ContentValues attvalue894 = new ContentValues();
        ContentValues attvalue895 = new ContentValues();
        ContentValues attvalue896 = new ContentValues();
        ContentValues attvalue897 = new ContentValues();
        ContentValues attvalue898 = new ContentValues();
        ContentValues attvalue899 = new ContentValues();
        ContentValues attvalue900 = new ContentValues();
        ContentValues attvalue901 = new ContentValues();
        ContentValues attvalue902 = new ContentValues();
        ContentValues attvalue903 = new ContentValues();
        ContentValues attvalue904 = new ContentValues();
        ContentValues attvalue905 = new ContentValues();
        ContentValues attvalue906 = new ContentValues();
        ContentValues attvalue907 = new ContentValues();
        ContentValues attvalue908 = new ContentValues();
        ContentValues attvalue909 = new ContentValues();
        ContentValues attvalue910 = new ContentValues();
        ContentValues attvalue911 = new ContentValues();
        ContentValues attvalue912 = new ContentValues();
        ContentValues attvalue913 = new ContentValues();
        ContentValues attvalue914 = new ContentValues();
        ContentValues attvalue915 = new ContentValues();
        ContentValues attvalue916 = new ContentValues();
        ContentValues attvalue917 = new ContentValues();
        ContentValues attvalue918 = new ContentValues();
        ContentValues attvalue919 = new ContentValues();
        ContentValues attvalue920 = new ContentValues();
        ContentValues attvalue921 = new ContentValues();
        ContentValues attvalue922 = new ContentValues();
        ContentValues attvalue923 = new ContentValues();
        ContentValues attvalue924 = new ContentValues();
        ContentValues attvalue925 = new ContentValues();
        ContentValues attvalue926 = new ContentValues();
        ContentValues attvalue927 = new ContentValues();
        ContentValues attvalue928 = new ContentValues();
        ContentValues attvalue929 = new ContentValues();
        ContentValues attvalue930 = new ContentValues();
        ContentValues attvalue931 = new ContentValues();
        ContentValues attvalue932 = new ContentValues();
        ContentValues attvalue933 = new ContentValues();
        ContentValues attvalue934 = new ContentValues();
        ContentValues attvalue935 = new ContentValues();
        ContentValues attvalue936 = new ContentValues();
        ContentValues attvalue937 = new ContentValues();
        ContentValues attvalue938 = new ContentValues();
        ContentValues attvalue939 = new ContentValues();
        ContentValues attvalue940 = new ContentValues();
        ContentValues attvalue941 = new ContentValues();
        ContentValues attvalue942 = new ContentValues();
        ContentValues attvalue943 = new ContentValues();
        ContentValues attvalue944 = new ContentValues();
        ContentValues attvalue945 = new ContentValues();
        ContentValues attvalue946 = new ContentValues();
        ContentValues attvalue947 = new ContentValues();
        ContentValues attvalue948 = new ContentValues();
        ContentValues attvalue949 = new ContentValues();
        ContentValues attvalue950 = new ContentValues();
        ContentValues attvalue951 = new ContentValues();
        ContentValues attvalue952 = new ContentValues();
        ContentValues attvalue953 = new ContentValues();
        ContentValues attvalue954 = new ContentValues();
        ContentValues attvalue955 = new ContentValues();
        ContentValues attvalue956 = new ContentValues();
        ContentValues attvalue957 = new ContentValues();
        ContentValues attvalue958 = new ContentValues();
        ContentValues attvalue959 = new ContentValues();
        ContentValues attvalue960 = new ContentValues();
        ContentValues attvalue961 = new ContentValues();
        ContentValues attvalue962 = new ContentValues();
        ContentValues attvalue963 = new ContentValues();
        ContentValues attvalue964 = new ContentValues();
        ContentValues attvalue965 = new ContentValues();
        ContentValues attvalue966 = new ContentValues();
        ContentValues attvalue967 = new ContentValues();
        ContentValues attvalue968 = new ContentValues();
        ContentValues attvalue969 = new ContentValues();
        ContentValues attvalue970 = new ContentValues();
        ContentValues attvalue971 = new ContentValues();
        ContentValues attvalue972 = new ContentValues();
        ContentValues attvalue973 = new ContentValues();
        ContentValues attvalue974 = new ContentValues();
        ContentValues attvalue975 = new ContentValues();
        ContentValues attvalue976 = new ContentValues();
        ContentValues attvalue977 = new ContentValues();
        ContentValues attvalue978 = new ContentValues();
        ContentValues attvalue979 = new ContentValues();
        ContentValues attvalue980 = new ContentValues();
        ContentValues attvalue981 = new ContentValues();
        ContentValues attvalue982 = new ContentValues();
        ContentValues attvalue983 = new ContentValues();
        ContentValues attvalue984 = new ContentValues();
        ContentValues attvalue985 = new ContentValues();
        ContentValues attvalue986 = new ContentValues();
        ContentValues attvalue987 = new ContentValues();
        ContentValues attvalue988 = new ContentValues();
        ContentValues attvalue989 = new ContentValues();
        ContentValues attvalue990 = new ContentValues();
        ContentValues attvalue991 = new ContentValues();
        ContentValues attvalue992 = new ContentValues();
        ContentValues attvalue993 = new ContentValues();
        ContentValues attvalue994 = new ContentValues();
        ContentValues attvalue995 = new ContentValues();
        ContentValues attvalue996 = new ContentValues();
        ContentValues attvalue997 = new ContentValues();
        ContentValues attvalue998 = new ContentValues();
        ContentValues attvalue999 = new ContentValues();
        ContentValues attvalue1000 = new ContentValues();


        attvalue501.put("AttitudeID",501);
        attvalue501.put("AttitudeWord","งก");
        attvalue501.put("AttitudeRank",-1);
        attvalue501.put("Emotion","8");

        attvalue502.put("AttitudeID",502);
        attvalue502.put("AttitudeWord","งง");
        attvalue502.put("AttitudeRank",-1);
        attvalue502.put("Emotion","8");

        attvalue503.put("AttitudeID",503);
        attvalue503.put("AttitudeWord","งงงวย");
        attvalue503.put("AttitudeRank",-1);
        attvalue503.put("Emotion","8");

        attvalue504.put("AttitudeID",504);
        attvalue504.put("AttitudeWord","งงงัน");
        attvalue504.put("AttitudeRank",-1);
        attvalue504.put("Emotion","8");

        attvalue505.put("AttitudeID",505);
        attvalue505.put("AttitudeWord","งมงาย");
        attvalue505.put("AttitudeRank",-1);
        attvalue505.put("Emotion","4");

        attvalue506.put("AttitudeID",506);
        attvalue506.put("AttitudeWord","งอแง");
        attvalue506.put("AttitudeRank",-1);
        attvalue506.put("Emotion","05");

        attvalue507.put("AttitudeID",507);
        attvalue507.put("AttitudeWord","งอน");
        attvalue507.put("AttitudeRank",-1);
        attvalue507.put("Emotion","05");

        attvalue508.put("AttitudeID",508);
        attvalue508.put("AttitudeWord","งอมแงม");
        attvalue508.put("AttitudeRank",-1);
        attvalue508.put("Emotion","0");

        attvalue509.put("AttitudeID",509);
        attvalue509.put("AttitudeWord","ง่อย");
        attvalue509.put("AttitudeRank",-1);
        attvalue509.put("Emotion","01");


        attvalue510.put("AttitudeID",510);
        attvalue510.put("AttitudeWord","งั่ง");
        attvalue510.put("AttitudeRank",-1);
        attvalue510.put("Emotion","4");

        attvalue511.put("AttitudeID",511);
        attvalue511.put("AttitudeWord","ง้ำ");
        attvalue511.put("AttitudeRank",-1);
        attvalue511.put("Emotion","8");

        attvalue512.put("AttitudeID",512);
        attvalue512.put("AttitudeWord","งี่เง่า");
        attvalue512.put("AttitudeRank",-1);
        attvalue512.put("Emotion","8");

        attvalue513.put("AttitudeID",513);
        attvalue513.put("AttitudeWord","งุนงง");
        attvalue513.put("AttitudeRank",-1);
        attvalue513.put("Emotion","8");

        attvalue514.put("AttitudeID",514);
        attvalue514.put("AttitudeWord","โง่");
        attvalue514.put("AttitudeRank",-1);
        attvalue514.put("Emotion","8");

        attvalue515.put("AttitudeID",515);
        attvalue515.put("AttitudeWord","จนตรอก");
        attvalue515.put("AttitudeRank",-1);
        attvalue515.put("Emotion","4");

        attvalue516.put("AttitudeID",516);
        attvalue516.put("AttitudeWord","จนมุม");
        attvalue516.put("AttitudeRank",-1);
        attvalue516.put("Emotion","4");

        attvalue517.put("AttitudeID",517);
        attvalue517.put("AttitudeWord","จองหอง");
        attvalue517.put("AttitudeRank",-1);
        attvalue517.put("Emotion","45");

        attvalue518.put("AttitudeID",518);
        attvalue518.put("AttitudeWord","จอมฉาว");
        attvalue518.put("AttitudeRank",-1);
        attvalue518.put("Emotion","5");

        attvalue519.put("AttitudeID",519);
        attvalue519.put("AttitudeWord","จอมวีน");
        attvalue519.put("AttitudeRank",-1);
        attvalue519.put("Emotion","5");

        attvalue520.put("AttitudeID",520);
        attvalue520.put("AttitudeWord","จ๋อย");
        attvalue520.put("AttitudeRank",-1);
        attvalue520.put("Emotion","0");

        attvalue521.put("AttitudeID",521);
        attvalue521.put("AttitudeWord","จัดจ้าน");
        attvalue521.put("AttitudeRank",-1);
        attvalue521.put("Emotion","8");

        attvalue522.put("AttitudeID",522);
        attvalue522.put("AttitudeWord","จับผิด");
        attvalue522.put("AttitudeRank",-1);
        attvalue522.put("Emotion","8");

        attvalue523.put("AttitudeID",523);
        attvalue523.put("AttitudeWord","จำใจ");
        attvalue523.put("AttitudeRank",-1);
        attvalue523.put("Emotion","1");

        attvalue524.put("AttitudeID",524);
        attvalue524.put("AttitudeWord","จำทน");
        attvalue524.put("AttitudeRank",-1);
        attvalue524.put("Emotion","8");

        attvalue525.put("AttitudeID",525);
        attvalue525.put("AttitudeWord","จิตตก");
        attvalue525.put("AttitudeRank",-1);
        attvalue525.put("Emotion","1");

        attvalue526.put("AttitudeID",526);
        attvalue526.put("AttitudeWord","จืดจาง");
        attvalue526.put("AttitudeRank",-1);
        attvalue526.put("Emotion","0");

        attvalue527.put("AttitudeID",527);
        attvalue527.put("AttitudeWord","จืดชืด");
        attvalue527.put("AttitudeRank",-1);
        attvalue527.put("Emotion","0");

        attvalue528.put("AttitudeID",528);
        attvalue528.put("AttitudeWord","จุกจิก");
        attvalue528.put("AttitudeRank",-1);
        attvalue528.put("Emotion","4");

        attvalue529.put("AttitudeID",529);
        attvalue529.put("AttitudeWord","จุ้น");
        attvalue529.put("AttitudeRank",-1);
        attvalue529.put("Emotion","8");

        attvalue530.put("AttitudeID",530);
        attvalue530.put("AttitudeWord","จู้จี้");
        attvalue530.put("AttitudeRank",-1);
        attvalue530.put("Emotion","5");

        attvalue531.put("AttitudeID",531);
        attvalue531.put("AttitudeWord","โจมตี");
        attvalue531.put("AttitudeRank",-1);
        attvalue531.put("Emotion","15");

        attvalue532.put("AttitudeID",532);
        attvalue532.put("AttitudeWord","ใจคด");
        attvalue532.put("AttitudeRank",-1);
        attvalue532.put("Emotion","8");

        attvalue533.put("AttitudeID",533);
        attvalue533.put("AttitudeWord","ใจแคบ");
        attvalue533.put("AttitudeRank",-1);
        attvalue533.put("Emotion","8");

        attvalue534.put("AttitudeID",534);
        attvalue534.put("AttitudeWord","ใจดำ");
        attvalue534.put("AttitudeRank",-1);
        attvalue534.put("Emotion","45");

        attvalue535.put("AttitudeID",535);
        attvalue535.put("AttitudeWord","ใจแตก");
        attvalue535.put("AttitudeRank",-1);
        attvalue535.put("Emotion","0");

        attvalue536.put("AttitudeID",536);
        attvalue536.put("AttitudeWord","ใจน้อย");
        attvalue536.put("AttitudeRank",-1);
        attvalue536.put("Emotion","05");

        attvalue537.put("AttitudeID",537);
        attvalue537.put("AttitudeWord","ใจบาป");
        attvalue537.put("AttitudeRank",-1);
        attvalue537.put("Emotion","1");

        attvalue538.put("AttitudeID",538);
        attvalue538.put("AttitudeWord","ใจแป้ว");
        attvalue538.put("AttitudeRank",-1);
        attvalue538.put("Emotion","0");

        attvalue539.put("AttitudeID",539);
        attvalue539.put("AttitudeWord","ใจร้อน");
        attvalue539.put("AttitudeRank",-1);
        attvalue539.put("Emotion","5");

        attvalue540.put("AttitudeID",540);
        attvalue540.put("AttitudeWord","ใจรันทด");
        attvalue540.put("AttitudeRank",-1);
        attvalue540.put("Emotion","015");

        attvalue541.put("AttitudeID",541);
        attvalue541.put("AttitudeWord","ใจร้าย");
        attvalue541.put("AttitudeRank",-1);
        attvalue541.put("Emotion","0");

        attvalue542.put("AttitudeID",542);
        attvalue542.put("AttitudeWord","ใจสลาย");
        attvalue542.put("AttitudeRank",-1);
        attvalue542.put("Emotion","0");

        attvalue543.put("AttitudeID",543);
        attvalue543.put("AttitudeWord","ใจหาย");
        attvalue543.put("AttitudeRank",-1);
        attvalue543.put("Emotion","1");

        attvalue544.put("AttitudeID",544);
        attvalue544.put("AttitudeWord","ฉกรรณ์");
        attvalue544.put("AttitudeRank",-1);
        attvalue544.put("Emotion","8");

        attvalue545.put("AttitudeID",545);
        attvalue545.put("AttitudeWord","ฉ้อโกง");
        attvalue545.put("AttitudeRank",-1);
        attvalue545.put("Emotion","45");

        attvalue546.put("AttitudeID",546);
        attvalue546.put("AttitudeWord","ฉ้อฉล");
        attvalue546.put("AttitudeRank",-1);
        attvalue546.put("Emotion","45");

        attvalue547.put("AttitudeID",547);
        attvalue547.put("AttitudeWord","ฉาบฉวย");
        attvalue547.put("AttitudeRank",-1);
        attvalue547.put("Emotion","8");

        attvalue548.put("AttitudeID",548);
        attvalue548.put("AttitudeWord","ฉาว");
        attvalue548.put("AttitudeRank",-1);
        attvalue548.put("Emotion","5");

        attvalue549.put("AttitudeID",549);
        attvalue549.put("AttitudeWord","ฉาวโฉ่");
        attvalue549.put("AttitudeRank",-1);
        attvalue549.put("Emotion","145");


        attvalue550.put("AttitudeID",550);
        attvalue550.put("AttitudeWord","ฉิบหาย");
        attvalue550.put("AttitudeRank",-1);
        attvalue550.put("Emotion","0");

        attvalue551.put("AttitudeID",551);
        attvalue551.put("AttitudeWord","ฉุน");
        attvalue551.put("AttitudeRank",-1);
        attvalue551.put("Emotion","4");

        attvalue552.put("AttitudeID",552);
        attvalue552.put("AttitudeWord","ฉุนเฉียว");
        attvalue552.put("AttitudeRank",-1);
        attvalue552.put("Emotion","5");

        attvalue553.put("AttitudeID",553);
        attvalue553.put("AttitudeWord","ฉุนอะ");
        attvalue553.put("AttitudeRank",-1);
        attvalue553.put("Emotion","4");

        attvalue554.put("AttitudeID",554);
        attvalue554.put("AttitudeWord","ฉูดฉาด");
        attvalue554.put("AttitudeRank",-1);
        attvalue554.put("Emotion","8");

        attvalue555.put("AttitudeID",555);
        attvalue555.put("AttitudeWord","แฉ");
        attvalue555.put("AttitudeRank",-1);
        attvalue555.put("Emotion","8");

        attvalue556.put("AttitudeID",556);
        attvalue556.put("AttitudeWord","โฉด");
        attvalue556.put("AttitudeRank",-1);
        attvalue556.put("Emotion","8");

        attvalue557.put("AttitudeID",557);
        attvalue557.put("AttitudeWord","ช็อก");
        attvalue557.put("AttitudeRank",-1);
        attvalue557.put("Emotion","15");

        attvalue558.put("AttitudeID",558);
        attvalue558.put("AttitudeWord","ช๊อก");
        attvalue558.put("AttitudeRank",-1);
        attvalue558.put("Emotion","15");


        attvalue559.put("AttitudeID",559);
        attvalue559.put("AttitudeWord","ชอกช้ำ");
        attvalue559.put("AttitudeRank",-1);
        attvalue559.put("Emotion","015");

        attvalue560.put("AttitudeID",560);
        attvalue560.put("AttitudeWord","ช็อค");
        attvalue560.put("AttitudeRank",-1);
        attvalue560.put("Emotion","15");

        attvalue561.put("AttitudeID",561);
        attvalue561.put("AttitudeWord","ช๊อค");
        attvalue561.put("AttitudeRank",-1);
        attvalue561.put("Emotion","15");

        attvalue562.put("AttitudeID",562);
        attvalue562.put("AttitudeWord","ชัง");
        attvalue562.put("AttitudeRank",-1);
        attvalue562.put("Emotion","45");



        attvalue563.put("AttitudeID",563);
        attvalue563.put("AttitudeWord","ชั่ว");
        attvalue563.put("AttitudeRank",-1);
        attvalue563.put("Emotion","0145");



        attvalue564.put("AttitudeID",564);
        attvalue564.put("AttitudeWord","ชั่วร้าย");
        attvalue564.put("AttitudeRank",-1);
        attvalue564.put("Emotion","0145");



        attvalue565.put("AttitudeID",565);
        attvalue565.put("AttitudeWord","ช้า");
        attvalue565.put("AttitudeRank",-1);
        attvalue565.put("Emotion","0");

        attvalue566.put("AttitudeID",566);
        attvalue566.put("AttitudeWord","ช้ำ");
        attvalue566.put("AttitudeRank",-1);
        attvalue566.put("Emotion","0");

        attvalue567.put("AttitudeID",567);
        attvalue567.put("AttitudeWord","ช้ำใจ");
        attvalue567.put("AttitudeRank",-1);
        attvalue567.put("Emotion","0145");



        attvalue568.put("AttitudeID",568);
        attvalue568.put("AttitudeWord","ชิงชัง");
        attvalue568.put("AttitudeRank",-1);
        attvalue568.put("Emotion","145");


        attvalue569.put("AttitudeID",569);
        attvalue569.put("AttitudeWord","ชีช้ำ");
        attvalue569.put("AttitudeRank",-1);
        attvalue569.put("Emotion","8");

        attvalue570.put("AttitudeID",570);
        attvalue570.put("AttitudeWord","ชืด");
        attvalue570.put("AttitudeRank",-1);
        attvalue570.put("Emotion","8");

        attvalue571.put("AttitudeID",571);
        attvalue571.put("AttitudeWord","ชุ่ย");
        attvalue571.put("AttitudeRank",-1);
        attvalue571.put("Emotion","45");

        attvalue572.put("AttitudeID",572);
        attvalue572.put("AttitudeWord","แช่ง");
        attvalue572.put("AttitudeRank",-1);
        attvalue572.put("Emotion","45");


        attvalue573.put("AttitudeID",573);
        attvalue573.put("AttitudeWord","ซกมก");
        attvalue573.put("AttitudeRank",-1);
        attvalue573.put("Emotion","4");

        attvalue574.put("AttitudeID",574);
        attvalue574.put("AttitudeWord","ซน");
        attvalue574.put("AttitudeRank",-1);
        attvalue574.put("Emotion","8");

        attvalue575.put("AttitudeID",575);
        attvalue575.put("AttitudeWord","ซมซาน");
        attvalue575.put("AttitudeRank",-1);
        attvalue575.put("Emotion","8");

        attvalue576.put("AttitudeID",576);
        attvalue576.put("AttitudeWord","ซวย");
        attvalue576.put("AttitudeRank",-1);
        attvalue576.put("Emotion","8");

        attvalue577.put("AttitudeID",577);
        attvalue577.put("AttitudeWord","ซวยซ้ำ");
        attvalue577.put("AttitudeRank",-1);
        attvalue577.put("Emotion","8");

        attvalue578.put("AttitudeID",578);
        attvalue578.put("AttitudeWord","ซอมซ่อ");
        attvalue578.put("AttitudeRank",-1);
        attvalue578.put("Emotion","0");

        attvalue579.put("AttitudeID",579);
        attvalue579.put("AttitudeWord","ซับซ้อน");
        attvalue579.put("AttitudeRank",-1);
        attvalue579.put("Emotion","8");

        attvalue580.put("AttitudeID",580);
        attvalue580.put("AttitudeWord","ซ้ำซ้อน");
        attvalue580.put("AttitudeRank",-1);
        attvalue580.put("Emotion","8");

        attvalue581.put("AttitudeID",581);
        attvalue581.put("AttitudeWord","ซ้ำซาก");
        attvalue581.put("AttitudeRank",-1);
        attvalue581.put("Emotion","8");

        attvalue582.put("AttitudeID",582);
        attvalue582.put("AttitudeWord","ซีด");
        attvalue582.put("AttitudeRank",-1);
        attvalue582.put("Emotion","8");

        attvalue583.put("AttitudeID",583);
        attvalue583.put("AttitudeWord","ซีเรียส");
        attvalue583.put("AttitudeRank",-1);
        attvalue583.put("Emotion","01");

        attvalue584.put("AttitudeID",584);
        attvalue584.put("AttitudeWord","ซึม");
        attvalue584.put("AttitudeRank",-1);
        attvalue584.put("Emotion","8");

        attvalue585.put("AttitudeID",585);
        attvalue585.put("AttitudeWord","ซึมเศร้า");
        attvalue585.put("AttitudeRank",-1);
        attvalue585.put("Emotion","01");


        attvalue586.put("AttitudeID",586);
        attvalue586.put("AttitudeWord","ซุกซน");
        attvalue586.put("AttitudeRank",-1);
        attvalue586.put("Emotion","45");

        attvalue587.put("AttitudeID",587);
        attvalue587.put("AttitudeWord","ซูบ");
        attvalue587.put("AttitudeRank",-1);
        attvalue587.put("Emotion","0");

        attvalue588.put("AttitudeID",588);
        attvalue588.put("AttitudeWord","เซง");
        attvalue588.put("AttitudeRank",-1);
        attvalue588.put("Emotion","8");

        attvalue589.put("AttitudeID",589);
        attvalue589.put("AttitudeWord","เซ็ง");
        attvalue589.put("AttitudeRank",-1);
        attvalue589.put("Emotion","8");

        attvalue590.put("AttitudeID",590);
        attvalue590.put("AttitudeWord","ดวงตก");
        attvalue590.put("AttitudeRank",-1);
        attvalue590.put("Emotion","8");

        attvalue591.put("AttitudeID",591);
        attvalue591.put("AttitudeWord","ด้อย");
        attvalue591.put("AttitudeRank",-1);
        attvalue591.put("Emotion","0");

        attvalue592.put("AttitudeID",592);
        attvalue592.put("AttitudeWord","ดักดาน");
        attvalue592.put("AttitudeRank",-1);
        attvalue592.put("Emotion","8");

        attvalue593.put("AttitudeID",593);
        attvalue593.put("AttitudeWord","ดันทุรัง");
        attvalue593.put("AttitudeRank",-1);
        attvalue593.put("Emotion","8");

        attvalue594.put("AttitudeID",594);
        attvalue594.put("AttitudeWord","ด่า");
        attvalue594.put("AttitudeRank",-1);
        attvalue594.put("Emotion","45");

        attvalue595.put("AttitudeID",595);
        attvalue595.put("AttitudeWord","ดื้อ");
        attvalue595.put("AttitudeRank",-1);
        attvalue595.put("Emotion","8");

        attvalue596.put("AttitudeID",596);
        attvalue596.put("AttitudeWord","ดื้อดึง");
        attvalue596.put("AttitudeRank",-1);
        attvalue596.put("Emotion","8");

        attvalue597.put("AttitudeID",597);
        attvalue597.put("AttitudeWord","ดุ");
        attvalue597.put("AttitudeRank",-1);
        attvalue597.put("Emotion","145");

        attvalue598.put("AttitudeID",598);
        attvalue598.put("AttitudeWord","ดุดัน");
        attvalue598.put("AttitudeRank",-1);
        attvalue598.put("Emotion","15");


        attvalue599.put("AttitudeID",599);
        attvalue599.put("AttitudeWord","ดุร้าย");
        attvalue599.put("AttitudeRank",-1);
        attvalue599.put("Emotion","145");

        attvalue600.put("AttitudeID",600);
        attvalue600.put("AttitudeWord","ดูแคลน");
        attvalue600.put("AttitudeRank",-1);
        attvalue600.put("Emotion","045");

        attvalue601.put("AttitudeID",601);
        attvalue601.put("AttitudeWord","ดูด้อย");
        attvalue601.put("AttitudeRank",-1);
        attvalue601.put("Emotion","0");

        attvalue602.put("AttitudeID",602);
        attvalue602.put("AttitudeWord","ดูถูก");
        attvalue602.put("AttitudeRank",-1);
        attvalue602.put("Emotion","045");

        attvalue603.put("AttitudeID",603);
        attvalue603.put("AttitudeWord","ดูหมอง");
        attvalue603.put("AttitudeRank",-1);
        attvalue603.put("Emotion","0");

        attvalue604.put("AttitudeID",604);
        attvalue604.put("AttitudeWord","แดกดัน");
        attvalue604.put("AttitudeRank",-1);
        attvalue604.put("Emotion","8");

        attvalue605.put("AttitudeID",605);
        attvalue605.put("AttitudeWord","โดนติ");
        attvalue605.put("AttitudeRank",-1);
        attvalue605.put("Emotion","45");

        attvalue606.put("AttitudeID",606);
        attvalue606.put("AttitudeWord","ตกข่าว");
        attvalue606.put("AttitudeRank",-1);
        attvalue606.put("Emotion","8");

        attvalue607.put("AttitudeID",607);
        attvalue607.put("AttitudeWord","ตกงาน");
        attvalue607.put("AttitudeRank",-1);
        attvalue607.put("Emotion","01");

        attvalue608.put("AttitudeID",608);
        attvalue608.put("AttitudeWord","ตกใจ");
        attvalue608.put("AttitudeRank",-1);
        attvalue608.put("Emotion","1");

        attvalue609.put("AttitudeID",609);
        attvalue609.put("AttitudeWord","ตกต่ำ");
        attvalue609.put("AttitudeRank",-1);
        attvalue609.put("Emotion","0");

        attvalue610.put("AttitudeID",610);
        attvalue610.put("AttitudeWord","ตกยาก");
        attvalue610.put("AttitudeRank",-1);
        attvalue610.put("Emotion","0");

        attvalue611.put("AttitudeID",611);
        attvalue611.put("AttitudeWord","ตกอับ");
        attvalue611.put("AttitudeRank",-1);
        attvalue611.put("Emotion","0");

        attvalue612.put("AttitudeID",612);
        attvalue612.put("AttitudeWord","ตบตา");
        attvalue612.put("AttitudeRank",-1);
        attvalue612.put("Emotion","8");

        attvalue613.put("AttitudeID",613);
        attvalue613.put("AttitudeWord","ตบะแตก");
        attvalue613.put("AttitudeRank",-1);
        attvalue613.put("Emotion","8");

        attvalue614.put("AttitudeID",614);
        attvalue614.put("AttitudeWord","ตรม");
        attvalue614.put("AttitudeRank",-1);
        attvalue614.put("Emotion","8");

        attvalue615.put("AttitudeID",615);
        attvalue615.put("AttitudeWord","ตรอมใจ");
        attvalue615.put("AttitudeRank",-1);
        attvalue615.put("Emotion","0");

        attvalue616.put("AttitudeID",616);
        attvalue616.put("AttitudeWord","ตระหนก");
        attvalue616.put("AttitudeRank",-1);
        attvalue616.put("Emotion","1");

        attvalue617.put("AttitudeID",617);
        attvalue617.put("AttitudeWord","ตวาด");
        attvalue617.put("AttitudeRank",-1);
        attvalue617.put("Emotion","5");

        attvalue618.put("AttitudeID",618);
        attvalue618.put("AttitudeWord","ต่อต้าน");
        attvalue618.put("AttitudeRank",-1);
        attvalue618.put("Emotion","8");

        attvalue619.put("AttitudeID",619);
        attvalue619.put("AttitudeWord","ตอแย");
        attvalue619.put("AttitudeRank",-1);
        attvalue619.put("Emotion","45");

        attvalue620.put("AttitudeID",620);
        attvalue620.put("AttitudeWord","ตะกละ");
        attvalue620.put("AttitudeRank",-1);
        attvalue620.put("Emotion","4");

        attvalue621.put("AttitudeID",621);
        attvalue621.put("AttitudeWord","ตะคอก");
        attvalue621.put("AttitudeRank",-1);
        attvalue621.put("Emotion","5");

        attvalue622.put("AttitudeID",622);
        attvalue622.put("AttitudeWord","ตัดพ้อ");
        attvalue622.put("AttitudeRank",-1);
        attvalue622.put("Emotion","0");

        attvalue623.put("AttitudeID",623);
        attvalue623.put("AttitudeWord","ตัวฉกาจ");
        attvalue623.put("AttitudeRank",-1);
        attvalue623.put("Emotion","8");

        attvalue624.put("AttitudeID",624);
        attvalue624.put("AttitudeWord","ต่ำ");
        attvalue624.put("AttitudeRank",-1);
        attvalue624.put("Emotion","0");

        attvalue625.put("AttitudeID",625);
        attvalue625.put("AttitudeWord","ตาขวาง");
        attvalue625.put("AttitudeRank",-1);
        attvalue625.put("Emotion","45");

        attvalue626.put("AttitudeID",626);
        attvalue626.put("AttitudeWord","ตาถั่ว");
        attvalue626.put("AttitudeRank",-1);
        attvalue626.put("Emotion","8");

        attvalue627.put("AttitudeID",627);
        attvalue627.put("AttitudeWord","ตายใจ");
        attvalue627.put("AttitudeRank",-1);
        attvalue627.put("Emotion","015");

        attvalue628.put("AttitudeID",628);
        attvalue628.put("AttitudeWord","ต่ำ");
        attvalue628.put("AttitudeRank",-1);
        attvalue628.put("Emotion","0");

        attvalue629.put("AttitudeID",629);
        attvalue629.put("AttitudeWord","ต่ำต้อย");
        attvalue629.put("AttitudeRank",-1);
        attvalue629.put("Emotion","04");

        attvalue630.put("AttitudeID",630);
        attvalue630.put("AttitudeWord","ตำตา");
        attvalue630.put("AttitudeRank",-1);
        attvalue630.put("Emotion","8");

        attvalue631.put("AttitudeID",631);
        attvalue631.put("AttitudeWord","ตำหนิ");
        attvalue631.put("AttitudeRank",-1);
        attvalue631.put("Emotion","45");

        attvalue632.put("AttitudeID",632);
        attvalue632.put("AttitudeWord","ติ");
        attvalue632.put("AttitudeRank",-1);
        attvalue632.put("Emotion","45");

        attvalue633.put("AttitudeID",633);
        attvalue633.put("AttitudeWord","ติดขัด");
        attvalue633.put("AttitudeRank",-1);
        attvalue633.put("Emotion","8");

        attvalue634.put("AttitudeID",634);
        attvalue634.put("AttitudeWord","ติดลบ");
        attvalue634.put("AttitudeRank",-1);
        attvalue634.put("Emotion","8");

        attvalue635.put("AttitudeID",635);
        attvalue635.put("AttitudeWord","ติติง");
        attvalue635.put("AttitudeRank",-1);
        attvalue635.put("Emotion","8");

        attvalue636.put("AttitudeID",636);
        attvalue636.put("AttitudeWord","ตีบตัน");
        attvalue636.put("AttitudeRank",-1);
        attvalue636.put("Emotion","8");

        attvalue637.put("AttitudeID",637);
        attvalue637.put("AttitudeWord","ตึงตัง");
        attvalue637.put("AttitudeRank",-1);
        attvalue637.put("Emotion","8");

        attvalue638.put("AttitudeID",638);
        attvalue638.put("AttitudeWord","ตื้อ");
        attvalue638.put("AttitudeRank",-1);
        attvalue638.put("Emotion","8");

        attvalue639.put("AttitudeID",639);
        attvalue639.put("AttitudeWord","ตุกติก");
        attvalue639.put("AttitudeRank",-1);
        attvalue639.put("Emotion","0145");

        attvalue640.put("AttitudeID",640);
        attvalue640.put("AttitudeWord","แตกคอ");
        attvalue640.put("AttitudeRank",-1);
        attvalue640.put("Emotion","8");

        attvalue641.put("AttitudeID",641);
        attvalue641.put("AttitudeWord","แตกแยก");
        attvalue641.put("AttitudeRank",-1);
        attvalue641.put("Emotion","8");

        attvalue642.put("AttitudeID",642);
        attvalue642.put("AttitudeWord","แตกหัก");
        attvalue642.put("AttitudeRank",-1);
        attvalue642.put("Emotion","8");

        attvalue643.put("AttitudeID",643);
        attvalue643.put("AttitudeWord","ถลำลึก");
        attvalue643.put("AttitudeRank",-1);
        attvalue643.put("Emotion","8");

        attvalue644.put("AttitudeID",644);
        attvalue644.put("AttitudeWord","ถอดใจ");
        attvalue644.put("AttitudeRank",-1);
        attvalue644.put("Emotion","0");

        attvalue645.put("AttitudeID",645);
        attvalue645.put("AttitudeWord","ถ่อย");
        attvalue645.put("AttitudeRank",-1);
        attvalue645.put("Emotion","0");

        attvalue646.put("AttitudeID",646);
        attvalue646.put("AttitudeWord","ถังแตก");
        attvalue646.put("AttitudeRank",-1);
        attvalue646.put("Emotion","8");

        attvalue647.put("AttitudeID",647);
        attvalue647.put("AttitudeWord","ถากถาง");
        attvalue647.put("AttitudeRank",-1);
        attvalue647.put("Emotion","8");

        attvalue648.put("AttitudeID",648);
        attvalue648.put("AttitudeWord","เถื่อน");
        attvalue648.put("AttitudeRank",-1);
        attvalue648.put("Emotion","145");

        attvalue649.put("AttitudeID",649);
        attvalue649.put("AttitudeWord","ทมิฬ");
        attvalue649.put("AttitudeRank",-1);
        attvalue649.put("Emotion","8");

        attvalue650.put("AttitudeID",650);
        attvalue650.put("AttitudeWord","ทรชน");
        attvalue650.put("AttitudeRank",-1);
        attvalue650.put("Emotion","15");

        attvalue651.put("AttitudeID",651);
        attvalue651.put("AttitudeWord","ทรพี");
        attvalue651.put("AttitudeRank",-1);
        attvalue651.put("Emotion","45");

        attvalue652.put("AttitudeID",652);
        attvalue652.put("AttitudeWord","ทรมาน");
        attvalue652.put("AttitudeRank",-1);
        attvalue652.put("Emotion","8");

        attvalue653.put("AttitudeID",653);
        attvalue653.put("AttitudeWord","ทรยศ");
        attvalue653.put("AttitudeRank",-1);
        attvalue653.put("Emotion","045");

        attvalue654.put("AttitudeID",654);
        attvalue654.put("AttitudeWord","ทราม");
        attvalue654.put("AttitudeRank",-1);
        attvalue654.put("Emotion","0145");

        attvalue655.put("AttitudeID",655);
        attvalue655.put("AttitudeWord","ทรุด");
        attvalue655.put("AttitudeRank",-1);
        attvalue655.put("Emotion","0");

        attvalue656.put("AttitudeID",656);
        attvalue656.put("AttitudeWord","ท้อ");
        attvalue656.put("AttitudeRank",-1);
        attvalue656.put("Emotion","0");

        attvalue657.put("AttitudeID",657);
        attvalue657.put("AttitudeWord","ท้อใจ");
        attvalue657.put("AttitudeRank",-1);
        attvalue657.put("Emotion","01");

        attvalue658.put("AttitudeID",658);
        attvalue658.put("AttitudeWord","ท้อถอย");
        attvalue658.put("AttitudeRank",-1);
        attvalue658.put("Emotion","0");

        attvalue659.put("AttitudeID",659);
        attvalue659.put("AttitudeWord","ท้อแท้");
        attvalue659.put("AttitudeRank",-1);
        attvalue659.put("Emotion","0");

        attvalue660.put("AttitudeID",660);
        attvalue660.put("AttitudeWord","ทะมึน");
        attvalue660.put("AttitudeRank",-1);
        attvalue660.put("Emotion","8");

        attvalue661.put("AttitudeID",661);
        attvalue661.put("AttitudeWord","ทะแม่ง");
        attvalue661.put("AttitudeRank",-1);
        attvalue661.put("Emotion","1");

        attvalue662.put("AttitudeID",662);
        attvalue662.put("AttitudeWord","ทะลึ่ง");
        attvalue662.put("AttitudeRank",-1);
        attvalue662.put("Emotion","8");

        attvalue663.put("AttitudeID",663);
        attvalue663.put("AttitudeWord","ทะเลาะ");
        attvalue663.put("AttitudeRank",-1);
        attvalue663.put("Emotion","5");

        attvalue664.put("AttitudeID",664);
        attvalue664.put("AttitudeWord","ทารุณ");
        attvalue664.put("AttitudeRank",-1);
        attvalue664.put("Emotion","0145");

        attvalue665.put("AttitudeID",665);
        attvalue665.put("AttitudeWord","ทำร้าย");
        attvalue665.put("AttitudeRank",-1);
        attvalue665.put("Emotion","15");

        attvalue666.put("AttitudeID",666);
        attvalue666.put("AttitudeWord","ทำลาย");
        attvalue666.put("AttitudeRank",-1);
        attvalue666.put("Emotion","015");


        attvalue667.put("AttitudeID",667);
        attvalue667.put("AttitudeWord","ทำแสบ");
        attvalue667.put("AttitudeRank",-1);
        attvalue667.put("Emotion","15");

        attvalue668.put("AttitudeID",668);
        attvalue668.put("AttitudeWord","ทึ่ม");
        attvalue668.put("AttitudeRank",-1);
        attvalue668.put("Emotion","8");

        attvalue669.put("AttitudeID",669);
        attvalue669.put("AttitudeWord","ทื่อ");
        attvalue669.put("AttitudeRank",-1);
        attvalue669.put("Emotion","8");

        attvalue670.put("AttitudeID",670);
        attvalue670.put("AttitudeWord","ทุกข์");
        attvalue670.put("AttitudeRank",-1);
        attvalue670.put("Emotion","0145");

        attvalue671.put("AttitudeID",671);
        attvalue671.put("AttitudeWord","ทุจริต");
        attvalue671.put("AttitudeRank",-1);
        attvalue671.put("Emotion","8");

        attvalue672.put("AttitudeID",672);
        attvalue672.put("AttitudeWord","ทุรกันดาร");
        attvalue672.put("AttitudeRank",-1);
        attvalue672.put("Emotion","8");

        attvalue673.put("AttitudeID",673);
        attvalue673.put("AttitudeWord","ทู่");
        attvalue673.put("AttitudeRank",-1);
        attvalue673.put("Emotion","8");

        attvalue674.put("AttitudeID",674);
        attvalue674.put("AttitudeWord","แทงใจ");
        attvalue674.put("AttitudeRank",-1);
        attvalue674.put("Emotion","8");

        attvalue675.put("AttitudeID",675);
        attvalue675.put("AttitudeWord","แทรกแซง");
        attvalue675.put("AttitudeRank",-1);
        attvalue675.put("Emotion","0");

        attvalue676.put("AttitudeID",676);
        attvalue676.put("AttitudeWord","แทะโลม");
        attvalue676.put("AttitudeRank",-1);
        attvalue676.put("Emotion","15");

        attvalue677.put("AttitudeID",677);
        attvalue677.put("AttitudeWord","โทรม");
        attvalue677.put("AttitudeRank",-1);
        attvalue677.put("Emotion","4");

        attvalue678.put("AttitudeID",678);
        attvalue678.put("AttitudeWord","โทษ");
        attvalue678.put("AttitudeRank",-1);
        attvalue678.put("Emotion","45");

        attvalue679.put("AttitudeID",679);
        attvalue679.put("AttitudeWord","นรก");
        attvalue679.put("AttitudeRank",-1);
        attvalue679.put("Emotion","0145");

        attvalue680.put("AttitudeID",680);
        attvalue680.put("AttitudeWord","น่วม");
        attvalue680.put("AttitudeRank",-1);
        attvalue680.put("Emotion","8");

        attvalue681.put("AttitudeID",681);
        attvalue681.put("AttitudeWord","นอกคอก");
        attvalue681.put("AttitudeRank",-1);
        attvalue681.put("Emotion","15");

        attvalue682.put("AttitudeID",682);
        attvalue682.put("AttitudeWord","นอกใจ");
        attvalue682.put("AttitudeRank",-1);
        attvalue682.put("Emotion","4");

        attvalue683.put("AttitudeID",683);
        attvalue683.put("AttitudeWord","น้อยใจ");
        attvalue683.put("AttitudeRank",-1);
        attvalue683.put("Emotion","015");

        attvalue684.put("AttitudeID",684);
        attvalue684.put("AttitudeWord","น่าเกลียด");
        attvalue684.put("AttitudeRank",-1);
        attvalue684.put("Emotion","4");

        attvalue685.put("AttitudeID",685);
        attvalue685.put("AttitudeWord","น่าชัง");
        attvalue685.put("AttitudeRank",-1);
        attvalue685.put("Emotion","4");

        attvalue686.put("AttitudeID",686);
        attvalue686.put("AttitudeWord","น้ำหน้า");
        attvalue686.put("AttitudeRank",-1);
        attvalue686.put("Emotion","4");

        attvalue687.put("AttitudeID",687);
        attvalue687.put("AttitudeWord","นินทา");
        attvalue687.put("AttitudeRank",-1);
        attvalue687.put("Emotion","8");

        attvalue688.put("AttitudeID",688);
        attvalue688.put("AttitudeWord","เน่า");
        attvalue688.put("AttitudeRank",-1);
        attvalue688.put("Emotion","014");

        attvalue689.put("AttitudeID",689);
        attvalue689.put("AttitudeWord","เน่าเหม็น");
        attvalue689.put("AttitudeRank",-1);
        attvalue689.put("Emotion","014");

        attvalue690.put("AttitudeID",690);
        attvalue690.put("AttitudeWord","บ่น");
        attvalue690.put("AttitudeRank",-1);
        attvalue690.put("Emotion","05");

        attvalue691.put("AttitudeID",691);
        attvalue691.put("AttitudeWord","บรรลัย");
        attvalue691.put("AttitudeRank",-1);
        attvalue691.put("Emotion","014");

        attvalue692.put("AttitudeID",692);
        attvalue692.put("AttitudeWord","บวมๆ");
        attvalue692.put("AttitudeRank",-1);
        attvalue692.put("Emotion","1");

        attvalue693.put("AttitudeID",693);
        attvalue693.put("AttitudeWord","บอบช้ำ");
        attvalue693.put("AttitudeRank",-1);
        attvalue693.put("Emotion","015");

        attvalue694.put("AttitudeID",694);
        attvalue694.put("AttitudeWord","บังอาจ");
        attvalue694.put("AttitudeRank",-1);
        attvalue694.put("Emotion","8");

        attvalue695.put("AttitudeID",695);
        attvalue695.put("AttitudeWord","บัดซบ");
        attvalue695.put("AttitudeRank",-1);
        attvalue695.put("Emotion","8");

        attvalue696.put("AttitudeID",696);
        attvalue696.put("AttitudeWord","บ้า");
        attvalue696.put("AttitudeRank",-1);
        attvalue696.put("Emotion","015");

        attvalue697.put("AttitudeID",697);
        attvalue697.put("AttitudeWord","บาดตา");
        attvalue697.put("AttitudeRank",-1);
        attvalue697.put("Emotion","8");

        attvalue698.put("AttitudeID",698);
        attvalue698.put("AttitudeWord","บาดหู");
        attvalue698.put("AttitudeRank",-1);
        attvalue698.put("Emotion","8");

        attvalue699.put("AttitudeID",699);
        attvalue699.put("AttitudeWord","บ้าตาย");
        attvalue699.put("AttitudeRank",-1);
        attvalue699.put("Emotion","8");

        attvalue700.put("AttitudeID",700);
        attvalue700.put("AttitudeWord","บ้าบอ");
        attvalue700.put("AttitudeRank",-1);
        attvalue700.put("Emotion","015");

        attvalue701.put("AttitudeID",701);
        attvalue701.put("AttitudeWord","บาป");
        attvalue701.put("AttitudeRank",-1);
        attvalue701.put("Emotion","0145");

        attvalue702.put("AttitudeID",702);
        attvalue702.put("AttitudeWord","บ้ายอ");
        attvalue702.put("AttitudeRank",-1);
        attvalue702.put("Emotion","8");

        attvalue703.put("AttitudeID",703);
        attvalue703.put("AttitudeWord","บิดเบี้ยว");
        attvalue703.put("AttitudeRank",-1);
        attvalue703.put("Emotion","4");

        attvalue704.put("AttitudeID",704);
        attvalue704.put("AttitudeWord","บื้อ");
        attvalue704.put("AttitudeRank",-1);
        attvalue704.put("Emotion","8");

        attvalue705.put("AttitudeID",705);
        attvalue705.put("AttitudeWord","บูด");
        attvalue705.put("AttitudeRank",-1);
        attvalue705.put("Emotion","8");

        attvalue706.put("AttitudeID",706);
        attvalue706.put("AttitudeWord","เบื่อ");
        attvalue706.put("AttitudeRank",-1);
        attvalue706.put("Emotion","8");

        attvalue707.put("AttitudeID",707);
        attvalue707.put("AttitudeWord","ปฏิกูล");
        attvalue707.put("AttitudeRank",-1);
        attvalue707.put("Emotion","4");

        attvalue708.put("AttitudeID",708);
        attvalue708.put("AttitudeWord","ปมด้อย");
        attvalue708.put("AttitudeRank",-1);
        attvalue708.put("Emotion","0");

        attvalue709.put("AttitudeID",709);
        attvalue709.put("AttitudeWord","ประจาน");
        attvalue709.put("AttitudeRank",-1);
        attvalue709.put("Emotion","45");

        attvalue710.put("AttitudeID",710);
        attvalue710.put("AttitudeWord","ประชด");
        attvalue710.put("AttitudeRank",-1);
        attvalue710.put("Emotion","8");

        attvalue711.put("AttitudeID",711);
        attvalue711.put("AttitudeWord","ประณาม");
        attvalue711.put("AttitudeRank",-1);
        attvalue711.put("Emotion","5");

        attvalue712.put("AttitudeID",712);
        attvalue712.put("AttitudeWord","ประมาท");
        attvalue712.put("AttitudeRank",-1);
        attvalue712.put("Emotion","45");

        attvalue713.put("AttitudeID",713);
        attvalue713.put("AttitudeWord","ประหลาด");
        attvalue713.put("AttitudeRank",-1);
        attvalue713.put("Emotion","4");

        attvalue714.put("AttitudeID",714);
        attvalue714.put("AttitudeWord","ปร่า");
        attvalue714.put("AttitudeRank",-1);
        attvalue714.put("Emotion","8");

        attvalue715.put("AttitudeID",715);
        attvalue715.put("AttitudeWord","ปลอม");
        attvalue715.put("AttitudeRank",-1);
        attvalue715.put("Emotion","8");

        attvalue716.put("AttitudeID",716);
        attvalue716.put("AttitudeWord","ปลอมปน");
        attvalue716.put("AttitudeRank",-1);
        attvalue716.put("Emotion","8");

        attvalue717.put("AttitudeID",717);
        attvalue717.put("AttitudeWord","ปวด");
        attvalue717.put("AttitudeRank",-1);
        attvalue717.put("Emotion","01");

        attvalue718.put("AttitudeID",718);
        attvalue718.put("AttitudeWord","ปวดใจ");
        attvalue718.put("AttitudeRank",-1);
        attvalue718.put("Emotion","015");

        attvalue719.put("AttitudeID",719);
        attvalue719.put("AttitudeWord","ปวดตับ");
        attvalue719.put("AttitudeRank",-1);
        attvalue719.put("Emotion","01");

        attvalue720.put("AttitudeID",720);
        attvalue720.put("AttitudeWord","ปวดตา");
        attvalue720.put("AttitudeRank",-1);
        attvalue720.put("Emotion","01");

        attvalue721.put("AttitudeID",721);
        attvalue721.put("AttitudeWord","ป่วน");
        attvalue721.put("AttitudeRank",-1);
        attvalue721.put("Emotion","8");

        attvalue722.put("AttitudeID",722);
        attvalue722.put("AttitudeWord","ป่วย");
        attvalue722.put("AttitudeRank",-1);
        attvalue722.put("Emotion","04");

        attvalue723.put("AttitudeID",723);
        attvalue723.put("AttitudeWord","ปอกลอก");
        attvalue723.put("AttitudeRank",-1);
        attvalue723.put("Emotion","8");

        attvalue724.put("AttitudeID",724);
        attvalue724.put("AttitudeWord","ปัญญาอ่อน");
        attvalue724.put("AttitudeRank",-1);
        attvalue724.put("Emotion","014");

        attvalue725.put("AttitudeID",725);
        attvalue725.put("AttitudeWord","ปั่นป่วน");
        attvalue725.put("AttitudeRank",-1);
        attvalue725.put("Emotion","15");

        attvalue726.put("AttitudeID",726);
        attvalue726.put("AttitudeWord","ปากจัด");
        attvalue726.put("AttitudeRank",-1);
        attvalue726.put("Emotion","8");

        attvalue727.put("AttitudeID",727);
        attvalue727.put("AttitudeWord","ปากดี");
        attvalue727.put("AttitudeRank",-1);
        attvalue727.put("Emotion","5");

        attvalue728.put("AttitudeID",728);
        attvalue728.put("AttitudeWord","ป่าเถื่อน");
        attvalue728.put("AttitudeRank",-1);
        attvalue728.put("Emotion","145");

        attvalue729.put("AttitudeID",729);
        attvalue729.put("AttitudeWord","เปราะบาง");
        attvalue729.put("AttitudeRank",-1);
        attvalue729.put("Emotion","01");

        attvalue730.put("AttitudeID",730);
        attvalue730.put("AttitudeWord","แป้ก");
        attvalue730.put("AttitudeRank",-1);
        attvalue730.put("Emotion","8");

        attvalue731.put("AttitudeID",731);
        attvalue731.put("AttitudeWord","แปร่ง");
        attvalue731.put("AttitudeRank",-1);
        attvalue731.put("Emotion","8");

        attvalue732.put("AttitudeID",732);
        attvalue732.put("AttitudeWord","แปลกประหลาด");
        attvalue732.put("AttitudeRank",-1);
        attvalue732.put("Emotion","8");

        attvalue733.put("AttitudeID",733);
        attvalue733.put("AttitudeWord","โป๊");
        attvalue733.put("AttitudeRank",-1);
        attvalue733.put("Emotion","8");

        attvalue734.put("AttitudeID",734);
        attvalue734.put("AttitudeWord","ผงะ");
        attvalue734.put("AttitudeRank",-1);
        attvalue734.put("Emotion","8");

        attvalue735.put("AttitudeID",735);
        attvalue735.put("AttitudeWord","ผลาญ");
        attvalue735.put("AttitudeRank",-1);
        attvalue735.put("Emotion","015");

        attvalue736.put("AttitudeID",736);
        attvalue736.put("AttitudeWord","ผวา");
        attvalue736.put("AttitudeRank",-1);
        attvalue736.put("Emotion","15");

        attvalue737.put("AttitudeID",737);
        attvalue737.put("AttitudeWord","ผิด");
        attvalue737.put("AttitudeRank",-1);
        attvalue737.put("Emotion","8");

        attvalue738.put("AttitudeID",738);
        attvalue738.put("AttitudeWord","ผิดใจ");
        attvalue738.put("AttitudeRank",-1);
        attvalue738.put("Emotion","8");

        attvalue739.put("AttitudeID",739);
        attvalue739.put("AttitudeWord","ผิดปรกติ");
        attvalue739.put("AttitudeRank",-1);
        attvalue739.put("Emotion","4");

        attvalue740.put("AttitudeID",740);
        attvalue740.put("AttitudeWord","ผิดพลาด");
        attvalue740.put("AttitudeRank",-1);
        attvalue740.put("Emotion","0");

        attvalue741.put("AttitudeID",741);
        attvalue741.put("AttitudeWord","ผิดๆ");
        attvalue741.put("AttitudeRank",-1);
        attvalue741.put("Emotion","8");

        attvalue742.put("AttitudeID",742);
        attvalue742.put("AttitudeWord","ผุ");
        attvalue742.put("AttitudeRank",-1);
        attvalue742.put("Emotion","01");

        attvalue743.put("AttitudeID",743);
        attvalue743.put("AttitudeWord","ผุพัง");
        attvalue743.put("AttitudeRank",-1);
        attvalue743.put("Emotion","01");

        attvalue744.put("AttitudeID",744);
        attvalue744.put("AttitudeWord","แผลง");
        attvalue744.put("AttitudeRank",-1);
        attvalue744.put("Emotion","8");

        attvalue745.put("AttitudeID",745);
        attvalue745.put("AttitudeWord","โผงผาง");
        attvalue745.put("AttitudeRank",-1);
        attvalue745.put("Emotion","8");

        attvalue746.put("AttitudeID",746);
        attvalue746.put("AttitudeWord","ฝ่อ");
        attvalue746.put("AttitudeRank",-1);
        attvalue746.put("Emotion","8");

        attvalue747.put("AttitudeID",747);
        attvalue747.put("AttitudeWord","ฝาด");
        attvalue747.put("AttitudeRank",-1);
        attvalue747.put("Emotion","8");

        attvalue748.put("AttitudeID",748);
        attvalue748.put("AttitudeWord","ฝ้าฟาง");
        attvalue748.put("AttitudeRank",-1);
        attvalue748.put("Emotion","01");

        attvalue749.put("AttitudeID",749);
        attvalue749.put("AttitudeWord","ฝืด");
        attvalue749.put("AttitudeRank",-1);
        attvalue749.put("Emotion","8");

        attvalue750.put("AttitudeID",750);
        attvalue750.put("AttitudeWord","ฝืน");
        attvalue750.put("AttitudeRank",-1);
        attvalue750.put("Emotion","1");

        attvalue751.put("AttitudeID",751);
        attvalue751.put("AttitudeWord","ฝืนใจ");
        attvalue751.put("AttitudeRank",-1);
        attvalue751.put("Emotion","15");

        attvalue752.put("AttitudeID",752);
        attvalue752.put("AttitudeWord","พ่นพิษ");
        attvalue752.put("AttitudeRank",-1);
        attvalue752.put("Emotion","14");

        attvalue753.put("AttitudeID",753);
        attvalue753.put("AttitudeWord","พยาบาท");
        attvalue753.put("AttitudeRank",-1);
        attvalue753.put("Emotion","15");

        attvalue754.put("AttitudeID",754);
        attvalue754.put("AttitudeWord","พร่ามัว");
        attvalue754.put("AttitudeRank",-1);
        attvalue754.put("Emotion","01");

        attvalue755.put("AttitudeID",755);
        attvalue755.put("AttitudeWord","พล่อย");
        attvalue755.put("AttitudeRank",-1);
        attvalue755.put("Emotion","8");

        attvalue756.put("AttitudeID",756);
        attvalue756.put("AttitudeWord","พลั้ง");
        attvalue756.put("AttitudeRank",-1);
        attvalue756.put("Emotion","8");

        attvalue757.put("AttitudeID",757);
        attvalue757.put("AttitudeWord","พลาด");
        attvalue757.put("AttitudeRank",-1);
        attvalue757.put("Emotion","01");

        attvalue758.put("AttitudeID",758);
        attvalue758.put("AttitudeWord","พะวง");
        attvalue758.put("AttitudeRank",-1);
        attvalue758.put("Emotion","01");

        attvalue759.put("AttitudeID",759);
        attvalue759.put("AttitudeWord","พัง");
        attvalue759.put("AttitudeRank",-1);
        attvalue759.put("Emotion","01");

        attvalue760.put("AttitudeID",760);
        attvalue760.put("AttitudeWord","พ่ายแพ้");
        attvalue760.put("AttitudeRank",-1);
        attvalue760.put("Emotion","0145");

        attvalue761.put("AttitudeID",761);
        attvalue761.put("AttitudeWord","พาล");
        attvalue761.put("AttitudeRank",-1);
        attvalue761.put("Emotion","15");

        attvalue762.put("AttitudeID",762);
        attvalue762.put("AttitudeWord","พิกล");
        attvalue762.put("AttitudeRank",-1);
        attvalue762.put("Emotion","3");

        attvalue763.put("AttitudeID",763);
        attvalue763.put("AttitudeWord","พินาศ");
        attvalue763.put("AttitudeRank",-1);
        attvalue763.put("Emotion","0145");

        attvalue764.put("AttitudeID",764);
        attvalue764.put("AttitudeWord","พิรุธ");
        attvalue764.put("AttitudeRank",-1);
        attvalue764.put("Emotion","12");

        attvalue765.put("AttitudeID",765);
        attvalue765.put("AttitudeWord","พิโรธ");
        attvalue765.put("AttitudeRank",-1);
        attvalue765.put("Emotion","45");

        attvalue766.put("AttitudeID",766);
        attvalue766.put("AttitudeWord","พิลึก");
        attvalue766.put("AttitudeRank",-1);
        attvalue766.put("Emotion","8");

        attvalue767.put("AttitudeID",767);
        attvalue767.put("AttitudeWord","พิสดาร");
        attvalue767.put("AttitudeRank",-1);
        attvalue767.put("Emotion","4");

        attvalue768.put("AttitudeID",768);
        attvalue768.put("AttitudeWord","เพลีย");
        attvalue768.put("AttitudeRank",-1);
        attvalue768.put("Emotion","8");

        attvalue769.put("AttitudeID",769);
        attvalue769.put("AttitudeWord","แพ้");
        attvalue769.put("AttitudeRank",-1);
        attvalue769.put("Emotion","0145");

        attvalue770.put("AttitudeID",770);
        attvalue770.put("AttitudeWord","แพง");
        attvalue770.put("AttitudeRank",-1);
        attvalue770.put("Emotion","8");

        attvalue771.put("AttitudeID",771);
        attvalue771.put("AttitudeWord","แพงสุด");
        attvalue771.put("AttitudeRank",-1);
        attvalue771.put("Emotion","8");

        attvalue772.put("AttitudeID",772);
        attvalue772.put("AttitudeWord","ฟุ้งซ่าน");
        attvalue772.put("AttitudeRank",-1);
        attvalue772.put("Emotion","5");

        attvalue773.put("AttitudeID",773);
        attvalue773.put("AttitudeWord","ฟุ้งเฟ้อ");
        attvalue773.put("AttitudeRank",-1);
        attvalue773.put("Emotion","8");

        attvalue774.put("AttitudeID",774);
        attvalue774.put("AttitudeWord","ฟูมฟาย");
        attvalue774.put("AttitudeRank",-1);
        attvalue774.put("Emotion","014");

        attvalue775.put("AttitudeID",775);
        attvalue775.put("AttitudeWord","มลทิน");
        attvalue775.put("AttitudeRank",-1);
        attvalue775.put("Emotion","0145");

        attvalue776.put("AttitudeID",776);
        attvalue776.put("AttitudeWord","มหาโหด");
        attvalue776.put("AttitudeRank",-1);
        attvalue776.put("Emotion","15");

        attvalue777.put("AttitudeID",777);
        attvalue777.put("AttitudeWord","มอม");
        attvalue777.put("AttitudeRank",-1);
        attvalue777.put("Emotion","4");

        attvalue778.put("AttitudeID",778);
        attvalue778.put("AttitudeWord","มอมแมม");
        attvalue778.put("AttitudeRank",-1);
        attvalue778.put("Emotion","4");

        attvalue779.put("AttitudeID",779);
        attvalue779.put("AttitudeWord","มักง่าย");
        attvalue779.put("AttitudeRank",-1);
        attvalue779.put("Emotion","45");

        attvalue780.put("AttitudeID",780);
        attvalue780.put("AttitudeWord","มั่ว");
        attvalue780.put("AttitudeRank",-1);
        attvalue780.put("Emotion","6");

        attvalue781.put("AttitudeID",781);
        attvalue781.put("AttitudeWord","มั่วซั่ว");
        attvalue781.put("AttitudeRank",-1);
        attvalue781.put("Emotion","0");

        attvalue782.put("AttitudeID",782);
        attvalue782.put("AttitudeWord","มาคุ");
        attvalue782.put("AttitudeRank",-1);
        attvalue782.put("Emotion","8");

        attvalue783.put("AttitudeID",783);
        attvalue783.put("AttitudeWord","มารยาท");
        attvalue783.put("AttitudeRank",-1);
        attvalue783.put("Emotion","8");

        attvalue784.put("AttitudeID",784);
        attvalue784.put("AttitudeWord","มึน");
        attvalue784.put("AttitudeRank",-1);
        attvalue784.put("Emotion","8");

        attvalue785.put("AttitudeID",785);
        attvalue785.put("AttitudeWord","มึนงง");
        attvalue785.put("AttitudeRank",-1);
        attvalue785.put("Emotion","8");

        attvalue786.put("AttitudeID",786);
        attvalue786.put("AttitudeWord","มืดมน");
        attvalue786.put("AttitudeRank",-1);
        attvalue786.put("Emotion","0");

        attvalue787.put("AttitudeID",787);
        attvalue787.put("AttitudeWord","มืดมัว");
        attvalue787.put("AttitudeRank",-1);
        attvalue787.put("Emotion","0");

        attvalue788.put("AttitudeID",788);
        attvalue788.put("AttitudeWord","มือไว");
        attvalue788.put("AttitudeRank",-1);
        attvalue788.put("Emotion","8");

        attvalue789.put("AttitudeID",789);
        attvalue789.put("AttitudeWord","มุทะลุ");
        attvalue789.put("AttitudeRank",-1);
        attvalue789.put("Emotion","15");

        attvalue790.put("AttitudeID",790);
        attvalue790.put("AttitudeWord","มุ่ย");
        attvalue790.put("AttitudeRank",-1);
        attvalue790.put("Emotion","045");

        attvalue791.put("AttitudeID",791);
        attvalue791.put("AttitudeWord","โม้");
        attvalue791.put("AttitudeRank",-1);
        attvalue791.put("Emotion","8");

        attvalue792.put("AttitudeID",792);
        attvalue792.put("AttitudeWord","โมหะ");
        attvalue792.put("AttitudeRank",-1);
        attvalue792.put("Emotion","45");

        attvalue793.put("AttitudeID",793);
        attvalue793.put("AttitudeWord","โมโห");
        attvalue793.put("AttitudeRank",-1);
        attvalue793.put("Emotion","45");

        attvalue794.put("AttitudeID",794);
        attvalue794.put("AttitudeWord","ย้วย");
        attvalue794.put("AttitudeRank",-1);
        attvalue794.put("Emotion","5");

        attvalue795.put("AttitudeID",795);
        attvalue795.put("AttitudeWord","ยโส");
        attvalue795.put("AttitudeRank",-1);
        attvalue795.put("Emotion","45");

        attvalue796.put("AttitudeID",796);
        attvalue796.put("AttitudeWord","ย่อท้อ");
        attvalue796.put("AttitudeRank",-1);
        attvalue796.put("Emotion","01");

        attvalue797.put("AttitudeID",797);
        attvalue797.put("AttitudeWord","ยอมแพ้");
        attvalue797.put("AttitudeRank",-1);
        attvalue797.put("Emotion","01");

        attvalue798.put("AttitudeID",798);
        attvalue798.put("AttitudeWord","ยักยอก");
        attvalue798.put("AttitudeRank",-1);
        attvalue798.put("Emotion","45");

        attvalue799.put("AttitudeID",799);
        attvalue799.put("AttitudeWord","ยับ");
        attvalue799.put("AttitudeRank",-1);
        attvalue799.put("Emotion","0");

        attvalue800.put("AttitudeID",800);
        attvalue800.put("AttitudeWord","ยั่วยุ");
        attvalue800.put("AttitudeRank",-1);
        attvalue800.put("Emotion","015");

        attvalue801.put("AttitudeID",801);
        attvalue801.put("AttitudeWord","ยาก");
        attvalue801.put("AttitudeRank",-1);
        attvalue801.put("Emotion","1");

        attvalue802.put("AttitudeID",802);
        attvalue802.put("AttitudeWord","ยากจน");
        attvalue802.put("AttitudeRank",-1);
        attvalue802.put("Emotion","01");

        attvalue803.put("AttitudeID",803);
        attvalue803.put("AttitudeWord","ยากไร้");
        attvalue803.put("AttitudeRank",-1);
        attvalue803.put("Emotion","01");

        attvalue804.put("AttitudeID",804);
        attvalue804.put("AttitudeWord","ยาน");
        attvalue804.put("AttitudeRank",-1);
        attvalue804.put("Emotion","8");

        attvalue805.put("AttitudeID",805);
        attvalue805.put("AttitudeWord","ย่ำยี");
        attvalue805.put("AttitudeRank",-1);
        attvalue805.put("Emotion","015");

        attvalue806.put("AttitudeID",806);
        attvalue806.put("AttitudeWord","ย่ำแย่");
        attvalue806.put("AttitudeRank",-1);
        attvalue806.put("Emotion","0145");

        attvalue807.put("AttitudeID",807);
        attvalue807.put("AttitudeWord","ยี้");
        attvalue807.put("AttitudeRank",-1);
        attvalue807.put("Emotion","45");

        attvalue808.put("AttitudeID",808);
        attvalue808.put("AttitudeWord","ยียวน");
        attvalue808.put("AttitudeRank",-1);
        attvalue808.put("Emotion","8");

        attvalue809.put("AttitudeID",809);
        attvalue809.put("AttitudeWord","ยืดยาด");
        attvalue809.put("AttitudeRank",-1);
        attvalue809.put("Emotion","8");

        attvalue810.put("AttitudeID",810);
        attvalue810.put("AttitudeWord","ยุ่ง");
        attvalue810.put("AttitudeRank",-1);
        attvalue810.put("Emotion","4");

        attvalue811.put("AttitudeID",811);
        attvalue811.put("AttitudeWord","ยุ่งยาก");
        attvalue811.put("AttitudeRank",-1);
        attvalue811.put("Emotion","0");

        attvalue812.put("AttitudeID",812);
        attvalue812.put("AttitudeWord","ยุ่งๆ");
        attvalue812.put("AttitudeRank",-1);
        attvalue812.put("Emotion","4");

        attvalue813.put("AttitudeID",813);
        attvalue813.put("AttitudeWord","ยุ่ย");
        attvalue813.put("AttitudeRank",-1);
        attvalue813.put("Emotion","4");

        attvalue814.put("AttitudeID",814);
        attvalue814.put("AttitudeWord","ยุแยง");
        attvalue814.put("AttitudeRank",-1);
        attvalue814.put("Emotion","8");

        attvalue815.put("AttitudeID",815);
        attvalue815.put("AttitudeWord","ยุแหย่");
        attvalue815.put("AttitudeRank",-1);
        attvalue815.put("Emotion","45");

        attvalue816.put("AttitudeID",816);
        attvalue816.put("AttitudeWord","ยู่ยี่");
        attvalue816.put("AttitudeRank",-1);
        attvalue816.put("Emotion","8");

        attvalue817.put("AttitudeID",817);
        attvalue817.put("AttitudeWord","แย่");
        attvalue817.put("AttitudeRank",-1);
        attvalue817.put("Emotion","0");

        attvalue818.put("AttitudeID",818);
        attvalue818.put("AttitudeWord","แยกทาง");
        attvalue818.put("AttitudeRank",-1);
        attvalue818.put("Emotion","8");

        attvalue819.put("AttitudeID",819);
        attvalue819.put("AttitudeWord","แย้ง");
        attvalue819.put("AttitudeRank",-1);
        attvalue819.put("Emotion","8");

        attvalue820.put("AttitudeID",820);
        attvalue820.put("AttitudeWord","รกตา");
        attvalue820.put("AttitudeRank",-1);
        attvalue820.put("Emotion","8");

        attvalue821.put("AttitudeID",821);
        attvalue821.put("AttitudeWord","รกล้าง");
        attvalue821.put("AttitudeRank",-1);
        attvalue821.put("Emotion","8");

        attvalue822.put("AttitudeID",822);
        attvalue822.put("AttitudeWord","รบกวน");
        attvalue822.put("AttitudeRank",-1);
        attvalue822.put("Emotion","05");

        attvalue823.put("AttitudeID",823);
        attvalue823.put("AttitudeWord","ร้อนใจ");
        attvalue823.put("AttitudeRank",-1);
        attvalue823.put("Emotion","1");

        attvalue824.put("AttitudeID",824);
        attvalue824.put("AttitudeWord","ร้อนรน");
        attvalue824.put("AttitudeRank",-1);
        attvalue824.put("Emotion","01");

        attvalue825.put("AttitudeID",825);
        attvalue825.put("AttitudeWord","ร่อแร่");
        attvalue825.put("AttitudeRank",-1);
        attvalue825.put("Emotion","0");

        attvalue826.put("AttitudeID",826);
        attvalue826.put("AttitudeWord","ระคาย");
        attvalue826.put("AttitudeRank",-1);
        attvalue826.put("Emotion","45");

        attvalue827.put("AttitudeID",827);
        attvalue827.put("AttitudeWord","ระทม");
        attvalue827.put("AttitudeRank",-1);
        attvalue827.put("Emotion","0");

        attvalue828.put("AttitudeID",828);
        attvalue828.put("AttitudeWord","ระบม");
        attvalue828.put("AttitudeRank",-1);
        attvalue828.put("Emotion","0");

        attvalue829.put("AttitudeID",829);
        attvalue829.put("AttitudeWord","ระแวง");
        attvalue829.put("AttitudeRank",-1);
        attvalue829.put("Emotion","145");

        attvalue830.put("AttitudeID",830);
        attvalue830.put("AttitudeWord","ระอา");
        attvalue830.put("AttitudeRank",-1);
        attvalue830.put("Emotion","4");

        attvalue831.put("AttitudeID",831);
        attvalue831.put("AttitudeWord","ระอาใจ");
        attvalue831.put("AttitudeRank",-1);
        attvalue831.put("Emotion","4");

        attvalue832.put("AttitudeID",832);
        attvalue832.put("AttitudeWord","รังเกียจ");
        attvalue832.put("AttitudeRank",-1);
        attvalue832.put("Emotion","0145");

        attvalue833.put("AttitudeID",833);
        attvalue833.put("AttitudeWord","รังแก");
        attvalue833.put("AttitudeRank",-1);
        attvalue833.put("Emotion","15");

        attvalue834.put("AttitudeID",834);
        attvalue834.put("AttitudeWord","รั้น");
        attvalue834.put("AttitudeRank",-1);
        attvalue834.put("Emotion","8");

        attvalue835.put("AttitudeID",835);
        attvalue835.put("AttitudeWord","รันทด");
        attvalue835.put("AttitudeRank",-1);
        attvalue835.put("Emotion","015");

        attvalue836.put("AttitudeID",836);
        attvalue836.put("AttitudeWord","ราคี");
        attvalue836.put("AttitudeRank",-1);
        attvalue836.put("Emotion","8");

        attvalue837.put("AttitudeID",837);
        attvalue837.put("AttitudeWord","ร้าย");
        attvalue837.put("AttitudeRank",-1);
        attvalue837.put("Emotion","0145");

        attvalue838.put("AttitudeID",838);
        attvalue838.put("AttitudeWord","ร้ายกาจ");
        attvalue838.put("AttitudeRank",-1);
        attvalue838.put("Emotion","145");

        attvalue839.put("AttitudeID",839);
        attvalue839.put("AttitudeWord","ร้าว");
        attvalue839.put("AttitudeRank",-1);
        attvalue839.put("Emotion","8");

        attvalue840.put("AttitudeID",840);
        attvalue840.put("AttitudeWord","ราวี");
        attvalue840.put("AttitudeRank",-1);
        attvalue840.put("Emotion","45");

        attvalue841.put("AttitudeID",841);
        attvalue841.put("AttitudeWord","รำคาญ");
        attvalue841.put("AttitudeRank",-1);
        attvalue841.put("Emotion","45");

        attvalue842.put("AttitudeID",842);
        attvalue842.put("AttitudeWord","ร่ำไร");
        attvalue842.put("AttitudeRank",-1);
        attvalue842.put("Emotion","8");

        attvalue843.put("AttitudeID",843);
        attvalue843.put("AttitudeWord","ริดลอน");
        attvalue843.put("AttitudeRank",-1);
        attvalue843.put("Emotion","8");

        attvalue844.put("AttitudeID",844);
        attvalue844.put("AttitudeWord","ริษยา");
        attvalue844.put("AttitudeRank",-1);
        attvalue844.put("Emotion","8");

        attvalue845.put("AttitudeID",845);
        attvalue845.put("AttitudeWord","รุกราน");
        attvalue845.put("AttitudeRank",-1);
        attvalue845.put("Emotion","45");

        attvalue846.put("AttitudeID",846);
        attvalue846.put("AttitudeWord","รุงรัง");
        attvalue846.put("AttitudeRank",-1);
        attvalue846.put("Emotion","8");

        attvalue847.put("AttitudeID",847);
        attvalue847.put("AttitudeWord","รุ่งริ่ง");
        attvalue847.put("AttitudeRank",-1);
        attvalue847.put("Emotion","8");

        attvalue848.put("AttitudeID",848);
        attvalue848.put("AttitudeWord","รุนแรง");
        attvalue848.put("AttitudeRank",-1);
        attvalue848.put("Emotion","8");

        attvalue849.put("AttitudeID",849);
        attvalue849.put("AttitudeWord","แรงจัง");
        attvalue849.put("AttitudeRank",-1);
        attvalue849.put("Emotion","145");

        attvalue850.put("AttitudeID",850);
        attvalue850.put("AttitudeWord","แรงส์");
        attvalue850.put("AttitudeRank",-1);
        attvalue850.put("Emotion","8");

        attvalue851.put("AttitudeID",851);
        attvalue851.put("AttitudeWord","แรด");
        attvalue851.put("AttitudeRank",-1);
        attvalue851.put("Emotion","4");

        attvalue852.put("AttitudeID",852);
        attvalue852.put("AttitudeWord","โรคจิต");
        attvalue852.put("AttitudeRank",-1);
        attvalue852.put("Emotion","015");

        attvalue853.put("AttitudeID",853);
        attvalue853.put("AttitudeWord","โรยรา");
        attvalue853.put("AttitudeRank",-1);
        attvalue853.put("Emotion","01");

        attvalue854.put("AttitudeID",854);
        attvalue854.put("AttitudeWord","ลงแดง");
        attvalue854.put("AttitudeRank",-1);
        attvalue854.put("Emotion","45");

        attvalue855.put("AttitudeID",855);
        attvalue855.put("AttitudeWord","ลนลาน");
        attvalue855.put("AttitudeRank",-1);
        attvalue855.put("Emotion","1");

        attvalue856.put("AttitudeID",856);
        attvalue856.put("AttitudeWord","ลบหลู่");
        attvalue856.put("AttitudeRank",-1);
        attvalue856.put("Emotion","045");

        attvalue857.put("AttitudeID",857);
        attvalue857.put("AttitudeWord","ล่ม");
        attvalue857.put("AttitudeRank",-1);
        attvalue857.put("Emotion","01");

        attvalue858.put("AttitudeID",858);
        attvalue858.put("AttitudeWord","ล่มจม");
        attvalue858.put("AttitudeRank",-1);
        attvalue858.put("Emotion","01");

        attvalue859.put("AttitudeID",859);
        attvalue859.put("AttitudeWord","ลวนลาม");
        attvalue859.put("AttitudeRank",-1);
        attvalue859.put("Emotion","0145");

        attvalue860.put("AttitudeID",860);
        attvalue860.put("AttitudeWord","ล่อลวง");
        attvalue860.put("AttitudeRank",-1);
        attvalue860.put("Emotion","145");

        attvalue861.put("AttitudeID",861);
        attvalue861.put("AttitudeWord","ละห้อย");
        attvalue861.put("AttitudeRank",-1);
        attvalue861.put("Emotion","04");

        attvalue862.put("AttitudeID",862);
        attvalue862.put("AttitudeWord","ละอาย");
        attvalue862.put("AttitudeRank",-1);
        attvalue862.put("Emotion","014");

        attvalue863.put("AttitudeID",863);
        attvalue863.put("AttitudeWord","ลักไก่");
        attvalue863.put("AttitudeRank",-1);
        attvalue863.put("Emotion","8");

        attvalue864.put("AttitudeID",864);
        attvalue864.put("AttitudeWord","ล้า");
        attvalue864.put("AttitudeRank",-1);
        attvalue864.put("Emotion","8");

        attvalue865.put("AttitudeID",865);
        attvalue865.put("AttitudeWord","ล่าช้า");
        attvalue865.put("AttitudeRank",-1);
        attvalue865.put("Emotion","8");

        attvalue866.put("AttitudeID",866);
        attvalue866.put("AttitudeWord","ลามก");
        attvalue866.put("AttitudeRank",-1);
        attvalue866.put("Emotion","4");

        attvalue867.put("AttitudeID",867);
        attvalue867.put("AttitudeWord","ลามปาม");
        attvalue867.put("AttitudeRank",-1);
        attvalue867.put("Emotion","01");

        attvalue868.put("AttitudeID",868);
        attvalue868.put("AttitudeWord","ล้าหลัง");
        attvalue868.put("AttitudeRank",-1);
        attvalue868.put("Emotion","8");

        attvalue869.put("AttitudeID",869);
        attvalue869.put("AttitudeWord","ลำบาก");
        attvalue869.put("AttitudeRank",-1);
        attvalue869.put("Emotion","8");

        attvalue870.put("AttitudeID",870);
        attvalue870.put("AttitudeWord","ลำพอง");
        attvalue870.put("AttitudeRank",-1);
        attvalue870.put("Emotion","3");

        attvalue871.put("AttitudeID",871);
        attvalue871.put("AttitudeWord","ลำเอียง");
        attvalue871.put("AttitudeRank",-1);
        attvalue871.put("Emotion","8");

        attvalue872.put("AttitudeID",872);
        attvalue872.put("AttitudeWord","ลึกลับ");
        attvalue872.put("AttitudeRank",-1);
        attvalue872.put("Emotion","1");

        attvalue873.put("AttitudeID",873);
        attvalue873.put("AttitudeWord","ลูบคม");
        attvalue873.put("AttitudeRank",-1);
        attvalue873.put("Emotion","05");

        attvalue874.put("AttitudeID",874);
        attvalue874.put("AttitudeWord","เลว");
        attvalue874.put("AttitudeRank",-1);
        attvalue874.put("Emotion","0");

        attvalue875.put("AttitudeID",875);
        attvalue875.put("AttitudeWord","เลวทราม");
        attvalue875.put("AttitudeRank",-1);
        attvalue875.put("Emotion","45");

        attvalue876.put("AttitudeID",876);
        attvalue876.put("AttitudeWord","เลวร้าย");
        attvalue876.put("AttitudeRank",-1);
        attvalue876.put("Emotion","0");

        attvalue877.put("AttitudeID",877);
        attvalue877.put("AttitudeWord","เลอะเทอะ");
        attvalue877.put("AttitudeRank",-1);
        attvalue877.put("Emotion","4");

        attvalue878.put("AttitudeID",878);
        attvalue878.put("AttitudeWord","เละเทะ");
        attvalue878.put("AttitudeRank",-1);
        attvalue878.put("Emotion","1");

        attvalue879.put("AttitudeID",879);
        attvalue879.put("AttitudeWord","แล้ง");
        attvalue879.put("AttitudeRank",-1);
        attvalue879.put("Emotion","8");

        attvalue880.put("AttitudeID",880);
        attvalue880.put("AttitudeWord","โลภ");
        attvalue880.put("AttitudeRank",-1);
        attvalue880.put("Emotion","4");

        attvalue881.put("AttitudeID",881);
        attvalue881.put("AttitudeWord","วกวน");
        attvalue881.put("AttitudeRank",-1);
        attvalue881.put("Emotion","8");

        attvalue882.put("AttitudeID",882);
        attvalue882.put("AttitudeWord","วอกแวก");
        attvalue882.put("AttitudeRank",-1);
        attvalue882.put("Emotion","1");

        attvalue883.put("AttitudeID",883);
        attvalue883.put("AttitudeWord","วายวอด");
        attvalue883.put("AttitudeRank",-1);
        attvalue883.put("Emotion","15");

        attvalue884.put("AttitudeID",884);
        attvalue884.put("AttitudeWord","วิกฤติ");
        attvalue884.put("AttitudeRank",-1);
        attvalue884.put("Emotion","8");

        attvalue885.put("AttitudeID",885);
        attvalue885.put("AttitudeWord","วิกลจริต");
        attvalue885.put("AttitudeRank",-1);
        attvalue885.put("Emotion","15");

        attvalue886.put("AttitudeID",886);
        attvalue886.put("AttitudeWord","วิงเวียน");
        attvalue886.put("AttitudeRank",-1);
        attvalue886.put("Emotion","8");

        attvalue887.put("AttitudeID",887);
        attvalue887.put("AttitudeWord","วิตก");
        attvalue887.put("AttitudeRank",-1);
        attvalue887.put("Emotion","01");

        attvalue888.put("AttitudeID",888);
        attvalue888.put("AttitudeWord","วิตถาร");
        attvalue888.put("AttitudeRank",-1);
        attvalue888.put("Emotion","4");

        attvalue889.put("AttitudeID",889);
        attvalue889.put("AttitudeWord","วินาศ");
        attvalue889.put("AttitudeRank",-1);
        attvalue889.put("Emotion","015");

        attvalue890.put("AttitudeID",890);
        attvalue890.put("AttitudeWord","วิบัติ");
        attvalue890.put("AttitudeRank",-1);
        attvalue890.put("Emotion","0145");

        attvalue891.put("AttitudeID",891);
        attvalue891.put("AttitudeWord","วิปริต");
        attvalue891.put("AttitudeRank",-1);
        attvalue891.put("Emotion","05");

        attvalue892.put("AttitudeID",892);
        attvalue892.put("AttitudeWord","วิปลาส");
        attvalue892.put("AttitudeRank",-1);
        attvalue892.put("Emotion","145");

        attvalue893.put("AttitudeID",893);
        attvalue893.put("AttitudeWord","วีน");
        attvalue893.put("AttitudeRank",-1);
        attvalue893.put("Emotion","5");

        attvalue894.put("AttitudeID",894);
        attvalue894.put("AttitudeWord","วุ่น");
        attvalue894.put("AttitudeRank",-1);
        attvalue894.put("Emotion","0");

        attvalue895.put("AttitudeID",895);
        attvalue895.put("AttitudeWord","วุ่นวาย");
        attvalue895.put("AttitudeRank",-1);
        attvalue895.put("Emotion","5");

        attvalue896.put("AttitudeID",896);
        attvalue896.put("AttitudeWord","โวย");
        attvalue896.put("AttitudeRank",-1);
        attvalue896.put("Emotion","15");

        attvalue897.put("AttitudeID",897);
        attvalue897.put("AttitudeWord","โวยวาย");
        attvalue897.put("AttitudeRank",-1);
        attvalue897.put("Emotion","14");

        attvalue898.put("AttitudeID",898);
        attvalue898.put("AttitudeWord","เศร้า");
        attvalue898.put("AttitudeRank",-1);
        attvalue898.put("Emotion","0");

        attvalue899.put("AttitudeID",899);
        attvalue899.put("AttitudeWord","เศร้าใจ");
        attvalue899.put("AttitudeRank",-1);
        attvalue899.put("Emotion","0");

        attvalue900.put("AttitudeID",900);
        attvalue900.put("AttitudeWord","โศก");
        attvalue900.put("AttitudeRank",-1);
        attvalue900.put("Emotion","0");
//
        attvalue900.put("AttitudeID",900);
        attvalue900.put("AttitudeWord","โศก");
        attvalue900.put("AttitudeRank",-1);
        attvalue900.put("Emotion","0");

        attvalue901.put("AttitudeID",901);
        attvalue901.put("AttitudeWord","สกปรก");
        attvalue901.put("AttitudeRank",-1);
        attvalue901.put("Emotion","4");

        attvalue902.put("AttitudeID",902);
        attvalue902.put("AttitudeWord","สงสาร");
        attvalue902.put("AttitudeRank",-1);
        attvalue902.put("Emotion","0");

        attvalue903.put("AttitudeID",903);
        attvalue903.put("AttitudeWord","สบถ");
        attvalue903.put("AttitudeRank",-1);
        attvalue903.put("Emotion","45");

        attvalue904.put("AttitudeID",904);
        attvalue904.put("AttitudeWord","สยอง");
        attvalue904.put("AttitudeRank",-1);
        attvalue904.put("Emotion","15");

        attvalue905.put("AttitudeID",905);
        attvalue905.put("AttitudeWord","สลด");
        attvalue905.put("AttitudeRank",-1);
        attvalue905.put("Emotion","0");

        attvalue906.put("AttitudeID",906);
        attvalue906.put("AttitudeWord","สลดใจ");
        attvalue906.put("AttitudeRank",-1);
        attvalue906.put("Emotion","01");

        attvalue907.put("AttitudeID",907);
        attvalue907.put("AttitudeWord","สลับซับซ้อน");
        attvalue907.put("AttitudeRank",-1);
        attvalue907.put("Emotion","8");

        attvalue908.put("AttitudeID",908);
        attvalue908.put("AttitudeWord","สวะ");
        attvalue908.put("AttitudeRank",-1);
        attvalue908.put("Emotion","8");

        attvalue909.put("AttitudeID",909);
        attvalue909.put("AttitudeWord","สอดรู้");
        attvalue909.put("AttitudeRank",-1);
        attvalue909.put("Emotion","5");

        attvalue910.put("AttitudeID",910);
        attvalue910.put("AttitudeWord","สอบตก");
        attvalue910.put("AttitudeRank",-1);
        attvalue910.put("Emotion","01");

        attvalue911.put("AttitudeID",911);
        attvalue911.put("AttitudeWord","สะเทือนใจ");
        attvalue911.put("AttitudeRank",-1);
        attvalue911.put("Emotion","015");

        attvalue912.put("AttitudeID",912);
        attvalue912.put("AttitudeWord","สะบักสะบอม");
        attvalue912.put("AttitudeRank",-1);
        attvalue912.put("Emotion","01");

        attvalue913.put("AttitudeID",913);
        attvalue913.put("AttitudeWord","สะอื้น");
        attvalue913.put("AttitudeRank",-1);
        attvalue913.put("Emotion","04");

        attvalue914.put("AttitudeID",914);
        attvalue914.put("AttitudeWord","สับสน");
        attvalue914.put("AttitudeRank",-1);
        attvalue914.put("Emotion","8");

        attvalue915.put("AttitudeID",915);
        attvalue915.put("AttitudeWord","สาบ");
        attvalue915.put("AttitudeRank",-1);
        attvalue915.put("Emotion","04");

        attvalue916.put("AttitudeID",916);
        attvalue916.put("AttitudeWord","สาป");
        attvalue916.put("AttitudeRank",-1);
        attvalue916.put("Emotion","0145");

        attvalue917.put("AttitudeID",917);
        attvalue917.put("AttitudeWord","สาระแน");
        attvalue917.put("AttitudeRank",-1);
        attvalue917.put("Emotion","5");


        attvalue918.put("AttitudeID",918);
        attvalue918.put("AttitudeWord","สาวไส้");
        attvalue918.put("AttitudeRank",-1);
        attvalue918.put("Emotion","8");

        attvalue919.put("AttitudeID",919);
        attvalue919.put("AttitudeWord","สำรอก");
        attvalue919.put("AttitudeRank",-1);
        attvalue919.put("Emotion","4");

        attvalue920.put("AttitudeID",920);
        attvalue920.put("AttitudeWord","สำส่อน");
        attvalue920.put("AttitudeRank",-1);
        attvalue920.put("Emotion","8");

        attvalue921.put("AttitudeID",921);
        attvalue921.put("AttitudeWord","สึกหรอ");
        attvalue921.put("AttitudeRank",-1);
        attvalue921.put("Emotion","01");

        attvalue922.put("AttitudeID",922);
        attvalue922.put("AttitudeWord","สุดทน");
        attvalue922.put("AttitudeRank",-1);
        attvalue922.put("Emotion","8");

        attvalue923.put("AttitudeID",923);
        attvalue923.put("AttitudeWord","เสียใจ");
        attvalue923.put("AttitudeRank",-1);
        attvalue923.put("Emotion","01");

        attvalue924.put("AttitudeID",924);
        attvalue924.put("AttitudeWord","แสบ");
        attvalue924.put("AttitudeRank",-1);
        attvalue924.put("Emotion","4");

        attvalue925.put("AttitudeID",925);
        attvalue925.put("AttitudeWord","แสยง");
        attvalue925.put("AttitudeRank",-1);
        attvalue925.put("Emotion","1");

        attvalue926.put("AttitudeID",926);
        attvalue926.put("AttitudeWord","แสยงใจ");
        attvalue926.put("AttitudeRank",-1);
        attvalue926.put("Emotion","1");

        attvalue927.put("AttitudeID",927);
        attvalue927.put("AttitudeWord","แสร้ง");
        attvalue927.put("AttitudeRank",-1);
        attvalue927.put("Emotion","8");

        attvalue928.put("AttitudeID",928);
        attvalue928.put("AttitudeWord","แสลง");
        attvalue928.put("AttitudeRank",-1);
        attvalue928.put("Emotion","1");

        attvalue929.put("AttitudeID",929);
        attvalue929.put("AttitudeWord","แสลงใจ");
        attvalue929.put("AttitudeRank",-1);
        attvalue929.put("Emotion","01");

        attvalue930.put("AttitudeID",930);
        attvalue930.put("AttitudeWord","โสโครก");
        attvalue930.put("AttitudeRank",-1);
        attvalue930.put("Emotion","4");

        attvalue931.put("AttitudeID",931);
        attvalue931.put("AttitudeWord","หงอ");
        attvalue931.put("AttitudeRank",-1);
        attvalue931.put("Emotion","1");

        attvalue932.put("AttitudeID",932);
        attvalue932.put("AttitudeWord","หงอย");
        attvalue932.put("AttitudeRank",-1);
        attvalue932.put("Emotion","04");

        attvalue933.put("AttitudeID",933);
        attvalue933.put("AttitudeWord","หดหู่");
        attvalue933.put("AttitudeRank",-1);
        attvalue933.put("Emotion","014");

        attvalue934.put("AttitudeID",934);
        attvalue934.put("AttitudeWord","หนวกหู");
        attvalue934.put("AttitudeRank",-1);
        attvalue934.put("Emotion","5");

        attvalue935.put("AttitudeID",935);
        attvalue935.put("AttitudeWord","หน่อมแน้ม");
        attvalue935.put("AttitudeRank",-1);
        attvalue935.put("Emotion","2");

        attvalue936.put("AttitudeID",936);
        attvalue936.put("AttitudeWord","หนัก");
        attvalue936.put("AttitudeRank",-1);
        attvalue936.put("Emotion","015");

        attvalue937.put("AttitudeID",937);
        attvalue937.put("AttitudeWord","หนักใจ");
        attvalue937.put("AttitudeRank",-1);
        attvalue937.put("Emotion","01");

        attvalue938.put("AttitudeID",938);
        attvalue938.put("AttitudeWord","หน้างอ");
        attvalue938.put("AttitudeRank",-1);
        attvalue938.put("Emotion","0");

        attvalue939.put("AttitudeID",939);
        attvalue939.put("AttitudeWord","หน้าชา");
        attvalue939.put("AttitudeRank",-1);
        attvalue939.put("Emotion","0");

        attvalue940.put("AttitudeID",940);
        attvalue940.put("AttitudeWord","หนาวใจ");
        attvalue940.put("AttitudeRank",-1);
        attvalue940.put("Emotion","0145");

        attvalue941.put("AttitudeID",941);
        attvalue941.put("AttitudeWord","หมดตัว");
        attvalue941.put("AttitudeRank",-1);
        attvalue941.put("Emotion","012");

        attvalue942.put("AttitudeID",942);
        attvalue942.put("AttitudeWord","หมดตูด");
        attvalue942.put("AttitudeRank",-1);
        attvalue942.put("Emotion","012");

        attvalue943.put("AttitudeID",943);
        attvalue943.put("AttitudeWord","หมดหวัง");
        attvalue943.put("AttitudeRank",-1);
        attvalue943.put("Emotion","8");

        attvalue944.put("AttitudeID",944);
        attvalue944.put("AttitudeWord","หม่น");
        attvalue944.put("AttitudeRank",-1);
        attvalue944.put("Emotion","0");

        attvalue945.put("AttitudeID",945);
        attvalue945.put("AttitudeWord","หมอง");
        attvalue945.put("AttitudeRank",-1);
        attvalue945.put("Emotion","0");

        attvalue946.put("AttitudeID",946);
        attvalue946.put("AttitudeWord","หมาง");
        attvalue946.put("AttitudeRank",-1);
        attvalue946.put("Emotion","8");

        attvalue947.put("AttitudeID",947);
        attvalue947.put("AttitudeWord","หมิ่น");
        attvalue947.put("AttitudeRank",-1);
        attvalue947.put("Emotion","05");

        attvalue948.put("AttitudeID",948);
        attvalue948.put("AttitudeWord","หยาบ");
        attvalue948.put("AttitudeRank",-1);
        attvalue948.put("Emotion","8");

        attvalue949.put("AttitudeID",949);
        attvalue949.put("AttitudeWord","หยาบคาย");
        attvalue949.put("AttitudeRank",-1);
        attvalue949.put("Emotion","15");

        attvalue950.put("AttitudeID",950);
        attvalue950.put("AttitudeWord","หยาม");
        attvalue950.put("AttitudeRank",-1);
        attvalue950.put("Emotion","045");

        attvalue951.put("AttitudeID",951);
        attvalue951.put("AttitudeWord","หยิ่ง");
        attvalue951.put("AttitudeRank",-1);
        attvalue951.put("Emotion","45");

        attvalue952.put("AttitudeID",952);
        attvalue952.put("AttitudeWord","หฤโหด");
        attvalue952.put("AttitudeRank",-1);
        attvalue952.put("Emotion","15");

        attvalue953.put("AttitudeID",953);
        attvalue953.put("AttitudeWord","หลงตัว");
        attvalue953.put("AttitudeRank",-1);
        attvalue953.put("Emotion","8");

        attvalue954.put("AttitudeID",954);
        attvalue954.put("AttitudeWord","หลอก");
        attvalue954.put("AttitudeRank",-1);
        attvalue954.put("Emotion","45");

        attvalue955.put("AttitudeID",955);
        attvalue955.put("AttitudeWord","หลอกตา");
        attvalue955.put("AttitudeRank",-1);
        attvalue955.put("Emotion","8");

        attvalue956.put("AttitudeID",956);
        attvalue956.put("AttitudeWord","หลอน");
        attvalue956.put("AttitudeRank",-1);
        attvalue956.put("Emotion","15");

        attvalue957.put("AttitudeID",957);
        attvalue957.put("AttitudeWord","หลายใจ");
        attvalue957.put("AttitudeRank",-1);
        attvalue957.put("Emotion","8");

        attvalue958.put("AttitudeID",958);
        attvalue958.put("AttitudeWord","ห้วน");
        attvalue958.put("AttitudeRank",-1);
        attvalue958.put("Emotion","8");

        attvalue959.put("AttitudeID",959);
        attvalue959.put("AttitudeWord","ห่วย");
        attvalue959.put("AttitudeRank",-1);
        attvalue959.put("Emotion","145");

        attvalue960.put("AttitudeID",960);
        attvalue960.put("AttitudeWord","หวั่น");
        attvalue960.put("AttitudeRank",-1);
        attvalue960.put("Emotion","16");

        attvalue961.put("AttitudeID",961);
        attvalue961.put("AttitudeWord","หวาด");
        attvalue961.put("AttitudeRank",-1);
        attvalue961.put("Emotion","16");

        attvalue962.put("AttitudeID",962);
        attvalue962.put("AttitudeWord","หักโหม");
        attvalue962.put("AttitudeRank",-1);
        attvalue962.put("Emotion","8");

        attvalue963.put("AttitudeID",963);
        attvalue963.put("AttitudeWord","หัวงู");
        attvalue963.put("AttitudeRank",-1);
        attvalue963.put("Emotion","8");

        attvalue964.put("AttitudeID",964);
        attvalue964.put("AttitudeWord","ห่า");
        attvalue964.put("AttitudeRank",-1);
        attvalue964.put("Emotion","45");

        attvalue965.put("AttitudeID",965);
        attvalue965.put("AttitudeWord","ห่าม");
        attvalue965.put("AttitudeRank",-1);
        attvalue965.put("Emotion","8");

        attvalue966.put("AttitudeID",966);
        attvalue966.put("AttitudeWord","หายนะ");
        attvalue966.put("AttitudeRank",-1);
        attvalue966.put("Emotion","015");

        attvalue967.put("AttitudeID",967);
        attvalue967.put("AttitudeWord","หิวโหย");
        attvalue967.put("AttitudeRank",-1);
        attvalue967.put("Emotion","8");

        attvalue968.put("AttitudeID",968);
        attvalue968.put("AttitudeWord","หึง");
        attvalue968.put("AttitudeRank",-1);
        attvalue968.put("Emotion","45");

        attvalue969.put("AttitudeID",969);
        attvalue969.put("AttitudeWord","หึงหวง");
        attvalue969.put("AttitudeRank",-1);
        attvalue969.put("Emotion","0145");

        attvalue970.put("AttitudeID",970);
        attvalue970.put("AttitudeWord","หื่น");
        attvalue970.put("AttitudeRank",-1);
        attvalue970.put("Emotion","6");

        attvalue971.put("AttitudeID",971);
        attvalue971.put("AttitudeWord","หูฉี่");
        attvalue971.put("AttitudeRank",-1);
        attvalue971.put("Emotion","8");

        attvalue972.put("AttitudeID",972);
        attvalue972.put("AttitudeWord","เหงา");
        attvalue972.put("AttitudeRank",-1);
        attvalue972.put("Emotion","0145");

        attvalue973.put("AttitudeID",973);
        attvalue973.put("AttitudeWord","เหนอะหนะ");
        attvalue973.put("AttitudeRank",-1);
        attvalue973.put("Emotion","8");

        attvalue974.put("AttitudeID",974);
        attvalue974.put("AttitudeWord","แหกตา");
        attvalue974.put("AttitudeRank",-1);
        attvalue974.put("Emotion","045");

        attvalue975.put("AttitudeID",975);
        attvalue975.put("AttitudeWord","แหม่ง");
        attvalue975.put("AttitudeRank",-1);
        attvalue975.put("Emotion","8");

        attvalue976.put("AttitudeID",976);
        attvalue976.put("AttitudeWord","แหยง");
        attvalue976.put("AttitudeRank",-1);
        attvalue976.put("Emotion","1");

        attvalue977.put("AttitudeID",977);
        attvalue977.put("AttitudeWord","แหล");
        attvalue977.put("AttitudeRank",-1);
        attvalue977.put("Emotion","5");

        attvalue978.put("AttitudeID",978);
        attvalue978.put("AttitudeWord","แหว่ง");
        attvalue978.put("AttitudeRank",-1);
        attvalue978.put("Emotion","8");

        attvalue979.put("AttitudeID",979);
        attvalue979.put("AttitudeWord","แหวะ");
        attvalue979.put("AttitudeRank",-1);
        attvalue979.put("Emotion","4");

        attvalue980.put("AttitudeID",980);
        attvalue980.put("AttitudeWord","โหด");
        attvalue980.put("AttitudeRank",-1);
        attvalue980.put("Emotion","15");

        attvalue981.put("AttitudeID",981);
        attvalue981.put("AttitudeWord","โหยหวน");
        attvalue981.put("AttitudeRank",-1);
        attvalue981.put("Emotion","15");

        attvalue982.put("AttitudeID",982);
        attvalue982.put("AttitudeWord","เลอะ");
        attvalue982.put("AttitudeRank",-1);
        attvalue982.put("Emotion","4");

        attvalue983.put("AttitudeID",983);
        attvalue983.put("AttitudeWord","อกหัก");
        attvalue983.put("AttitudeRank",-1);
        attvalue983.put("Emotion","01");

        attvalue984.put("AttitudeID",984);
        attvalue984.put("AttitudeWord","อคติ");
        attvalue984.put("AttitudeRank",-1);
        attvalue984.put("Emotion","5");

        attvalue985.put("AttitudeID",985);
        attvalue985.put("AttitudeWord","อโคจร");
        attvalue985.put("AttitudeRank",-1);
        attvalue985.put("Emotion","45");

        attvalue986.put("AttitudeID",986);
        attvalue986.put("AttitudeWord","อดสู");
        attvalue986.put("AttitudeRank",-1);
        attvalue986.put("Emotion","0");

        attvalue987.put("AttitudeID",987);
        attvalue987.put("AttitudeWord","อดอยาก");
        attvalue987.put("AttitudeRank",-1);
        attvalue987.put("Emotion","8");

        attvalue988.put("AttitudeID",988);
        attvalue988.put("AttitudeWord","อนาจาร");
        attvalue988.put("AttitudeRank",-1);
        attvalue988.put("Emotion","4");

        attvalue989.put("AttitudeID",989);
        attvalue989.put("AttitudeWord","อนาถ");
        attvalue989.put("AttitudeRank",-1);
        attvalue989.put("Emotion","045");

        attvalue990.put("AttitudeID",990);
        attvalue990.put("AttitudeWord","อนาถใจ");
        attvalue990.put("AttitudeRank",-1);
        attvalue990.put("Emotion","045");

        attvalue991.put("AttitudeID",991);
        attvalue991.put("AttitudeWord","อนาถา");
        attvalue991.put("AttitudeRank",-1);
        attvalue991.put("Emotion","01");

        attvalue992.put("AttitudeID",992);
        attvalue992.put("AttitudeWord","อ้วก");
        attvalue992.put("AttitudeRank",-1);
        attvalue992.put("Emotion","4");

        attvalue993.put("AttitudeID",993);
        attvalue993.put("AttitudeWord","อวดรวย");
        attvalue993.put("AttitudeRank",-1);
        attvalue993.put("Emotion","45");

        attvalue994.put("AttitudeID",994);
        attvalue994.put("AttitudeWord","อวดรู้");
        attvalue994.put("AttitudeRank",-1);
        attvalue994.put("Emotion","45");

        attvalue995.put("AttitudeID",995);
        attvalue995.put("AttitudeWord","อ่อนใจ");
        attvalue995.put("AttitudeRank",-1);
        attvalue995.put("Emotion","0");

        attvalue996.put("AttitudeID",996);
        attvalue996.put("AttitudeWord","อ่อนล้า");
        attvalue996.put("AttitudeRank",-1);
        attvalue996.put("Emotion","8");

        attvalue997.put("AttitudeID",997);
        attvalue997.put("AttitudeWord","อ่อนแอ");
        attvalue997.put("AttitudeRank",-1);
        attvalue997.put("Emotion","01");

        attvalue998.put("AttitudeID",998);
        attvalue998.put("AttitudeWord","อัดใจ");
        attvalue998.put("AttitudeRank",-1);
        attvalue998.put("Emotion","01");

        attvalue999.put("AttitudeID",999);
        attvalue999.put("AttitudeWord","อัตคัด");
        attvalue999.put("AttitudeRank",-1);
        attvalue999.put("Emotion","01");

        attvalue1000.put("AttitudeID",1000);
        attvalue1000.put("AttitudeWord","อับอาย");
        attvalue1000.put("AttitudeRank",-1);
        attvalue1000.put("Emotion","04");

        String table_nameatt2 = "Attitudetable2";

        sqLiteDatabase.insert(table_nameatt2,null,attvalue501);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue502);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue503);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue504);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue505);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue506);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue507);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue508);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue509);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue510);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue511);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue512);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue513);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue514);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue515);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue516);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue517);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue518);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue519);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue520);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue521);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue522);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue523);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue524);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue525);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue526);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue527);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue528);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue529);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue530);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue531);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue532);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue533);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue534);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue535);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue536);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue537);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue538);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue539);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue540);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue541);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue542);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue543);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue544);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue545);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue546);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue547);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue548);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue549);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue550);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue551);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue552);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue553);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue554);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue555);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue556);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue557);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue558);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue559);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue560);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue561);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue562);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue563);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue564);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue565);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue566);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue567);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue568);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue569);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue570);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue571);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue572);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue573);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue574);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue575);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue576);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue577);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue578);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue579);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue580);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue581);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue582);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue583);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue584);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue585);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue586);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue587);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue588);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue589);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue590);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue591);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue592);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue593);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue594);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue595);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue596);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue597);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue598);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue599);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue600);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue601);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue602);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue603);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue604);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue605);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue606);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue607);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue608);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue609);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue610);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue611);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue612);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue613);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue614);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue615);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue616);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue617);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue618);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue619);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue620);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue621);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue622);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue623);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue624);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue625);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue626);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue627);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue628);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue629);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue630);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue631);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue632);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue633);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue634);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue635);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue636);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue637);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue638);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue639);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue640);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue641);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue642);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue643);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue644);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue645);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue646);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue647);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue648);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue649);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue650);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue651);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue652);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue653);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue654);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue655);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue656);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue657);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue658);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue659);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue660);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue661);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue662);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue663);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue664);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue665);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue666);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue667);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue668);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue669);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue670);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue671);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue672);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue673);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue674);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue675);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue676);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue677);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue678);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue679);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue680);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue681);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue682);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue683);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue684);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue685);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue686);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue687);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue688);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue689);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue690);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue691);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue692);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue693);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue694);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue695);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue696);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue697);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue698);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue699);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue700);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue701);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue702);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue703);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue704);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue705);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue706);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue707);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue708);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue709);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue710);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue711);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue712);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue713);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue714);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue715);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue716);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue717);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue718);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue719);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue720);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue721);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue722);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue723);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue724);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue725);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue726);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue727);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue728);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue729);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue730);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue731);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue732);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue733);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue734);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue735);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue736);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue737);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue738);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue739);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue740);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue741);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue742);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue743);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue744);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue745);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue746);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue747);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue748);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue749);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue750);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue751);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue752);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue753);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue754);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue755);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue756);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue757);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue758);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue759);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue760);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue761);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue762);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue763);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue764);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue765);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue766);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue767);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue768);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue769);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue770);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue771);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue772);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue773);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue774);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue775);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue776);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue777);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue778);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue779);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue780);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue781);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue782);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue783);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue784);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue785);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue786);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue787);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue788);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue789);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue790);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue791);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue792);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue793);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue794);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue795);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue796);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue797);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue798);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue799);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue800);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue801);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue802);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue803);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue804);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue805);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue806);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue807);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue808);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue809);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue810);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue811);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue812);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue813);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue814);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue815);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue816);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue817);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue818);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue819);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue820);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue821);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue822);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue823);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue824);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue825);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue826);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue827);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue828);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue829);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue830);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue831);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue832);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue833);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue834);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue835);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue836);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue837);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue838);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue839);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue840);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue841);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue842);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue843);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue844);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue845);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue846);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue847);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue848);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue849);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue850);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue851);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue852);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue853);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue854);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue855);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue856);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue857);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue858);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue859);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue860);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue861);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue862);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue863);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue864);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue865);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue866);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue867);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue868);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue869);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue870);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue871);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue872);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue873);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue874);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue875);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue876);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue877);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue878);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue879);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue880);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue881);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue882);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue883);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue884);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue885);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue886);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue887);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue888);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue889);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue890);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue891);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue892);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue893);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue894);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue895);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue896);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue897);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue898);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue899);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue900);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue901);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue902);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue903);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue904);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue905);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue906);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue907);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue908);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue909);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue910);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue911);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue912);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue913);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue914);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue915);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue916);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue917);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue918);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue919);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue920);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue921);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue922);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue923);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue924);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue925);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue926);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue927);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue928);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue929);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue930);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue931);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue932);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue933);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue934);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue935);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue936);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue937);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue938);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue939);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue940);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue941);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue942);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue943);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue944);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue945);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue946);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue947);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue948);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue949);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue950);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue951);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue952);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue953);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue954);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue955);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue956);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue957);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue958);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue959);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue960);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue961);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue962);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue963);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue964);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue965);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue966);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue967);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue968);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue969);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue970);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue971);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue972);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue973);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue974);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue975);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue976);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue977);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue978);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue979);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue980);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue981);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue982);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue983);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue984);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue985);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue986);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue987);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue988);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue989);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue990);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue991);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue992);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue993);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue994);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue995);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue996);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue997);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue998);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue999);
        sqLiteDatabase.insert(table_nameatt2,null,attvalue1000);


    }

    public ArrayList<HashMap<String,String>> getAttitudeList2(){
        try{

            ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
            HashMap<String,String> map;
            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "SELECT * FROM " + tableName4;
            Cursor cur = db.rawQuery(sql,null);
            if(cur!= null){
                if(cur.moveToFirst()){

                    do{
                        map = new HashMap<String,String>();
                        map.put("AttitudeID",cur.getString(0));
                        map.put("AttitudeWord",cur.getString(1));
                        map.put("AttitudeRank",cur.getString(2));
                        map.put("Emotion",cur.getString(3));
                        arr.add(map);

                    }while (cur.moveToNext());
                }

            }
            cur.close();
            db.close();
            return arr;
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
