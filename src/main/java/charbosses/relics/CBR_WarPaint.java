package charbosses.relics;

import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.WarPaint;

import charbosses.bosses.AbstractCharBoss;

import java.util.*;

public class CBR_WarPaint extends AbstractCharbossRelic
{
    
    public CBR_WarPaint() {
        super(new WarPaint());
    }
    
    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0] + 2 + this.DESCRIPTIONS[1];
    }
    
    @Override
    public void onEquip() {
        final ArrayList<AbstractCard> upgradableCards = new ArrayList<AbstractCard>();
        for (final AbstractCard c : AbstractCharBoss.boss.masterDeck.group) {
            if (c.canUpgrade() && c.type == AbstractCard.CardType.SKILL) {
                upgradableCards.add(c);
            }
        }
        Collections.shuffle(upgradableCards, new Random(AbstractDungeon.monsterRng.randomLong()));
        if (!upgradableCards.isEmpty()) {
            if (upgradableCards.size() == 1) {
                upgradableCards.get(0).upgrade();
            }
            else {
                upgradableCards.get(0).upgrade();
                upgradableCards.get(1).upgrade();
            }
        }
    }
    
    @Override
    public AbstractRelic makeCopy() {
        return new CBR_WarPaint();
    }
}