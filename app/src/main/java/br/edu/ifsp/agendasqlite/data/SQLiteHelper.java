package br.edu.ifsp.agendasqlite.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "agenda.db";
    static final String TABLE_NAME = "contatos";

    static final String KEY_ID = "id";
    static final String KEY_NOME = "nome";
    static final String KEY_FONE = "fone";
    static final String KEY_FONE_2 = "fone2";
    static final String KEY_EMAIL = "email";
    static final String KEY_FAVORITO = "favorito";
    public static final String KEY_DATA_NASCIMENTO = "data_nascimento";

    private static final int DATABASE_VERSION = 4;

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_NOME + " TEXT, "
            + KEY_FONE + " TEXT, "
            + KEY_EMAIL + " TEXT);";

    private static final String UPGRADE_VERSION_2 = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN "
            + KEY_FAVORITO + " TEXT;";

    private static final String UPGRADE_VERSION_3 = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN "
            + KEY_FONE_2 + " TEXT;";

    private static final String UPGRADE_VERSION_4 = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN "
            + KEY_DATA_NASCIMENTO + " TEXT;";

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1) {
            db.execSQL(UPGRADE_VERSION_2);
        } else if (oldVersion == 2) {
            db.execSQL(UPGRADE_VERSION_3);
        } else if (oldVersion == 3) {
            db.execSQL(UPGRADE_VERSION_4);
        }
    }
}
