package expansioncontent.actions;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


public class RandomCardWithTagAction extends AbstractGameAction {
    public boolean upgradeCard;
    public AbstractCard.CardTags tag;
    public boolean free;
    public boolean oneless;

    public RandomCardWithTagAction(boolean upgraded, AbstractCard.CardTags tagToSearch) {
        this.upgradeCard = upgraded;
        this.tag = tagToSearch;
        this.free = true;
        this.oneless = false;
    }

    public RandomCardWithTagAction(boolean upgraded, AbstractCard.CardTags tagToSearch, boolean free) {
        this.upgradeCard = upgraded;
        this.tag = tagToSearch;
        this.free = free;
        this.oneless = false;
    }

    public RandomCardWithTagAction(boolean upgraded, AbstractCard.CardTags tagToSearch, boolean free, boolean oneless) {
        this.upgradeCard = upgraded;
        this.tag = tagToSearch;
        this.free = free;
        this.oneless = oneless;
    }

    public void update() {

        ArrayList<String> tmp = new ArrayList();
        Iterator var3 = CardLibrary.cards.entrySet().iterator();

        while (var3.hasNext()) {
            Map.Entry<String, AbstractCard> c = (Map.Entry) var3.next();
            if (c.getValue().hasTag(tag)) {
                tmp.add(c.getKey());
            }
        }


        AbstractCard cStudy = CardLibrary.cards.get(tmp.get(AbstractDungeon.cardRng.random(0, tmp.size() - 1)));
        if (this.upgradeCard) {
            cStudy.upgrade();
        }
        if (this.free) {
            cStudy.freeToPlayOnce = true;
        }
        if (this.oneless) {
            cStudy.modifyCostForCombat(-1);
        }

        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(cStudy));

        this.isDone = true;
    }

}


