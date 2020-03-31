package charbosses.relics.EventRelics;

import charbosses.bosses.AbstractCharBoss;
import charbosses.cards.AbstractBossCard;
import charbosses.cards.curses.EnParasite;
import charbosses.relics.AbstractCharbossRelic;
import charbosses.relics.CBR_OddMushroom;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import evilWithin.EvilWithinMod;

import java.util.ArrayList;


public class CBR_ScrapOoze extends AbstractCharbossRelic {
    public static String ID = EvilWithinMod.makeID("ScrapOoze");
    private static RelicTier tier = RelicTier.SPECIAL;
    private static LandingSound sound = LandingSound.MAGICAL;
    private String addedName;

    public CBR_ScrapOoze() {
        super(ID, tier, sound, new Texture(EvilWithinMod.assetPath("images/relics/scrapooze.png")));
    }

    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new CBR_ScrapOoze();
    }
}