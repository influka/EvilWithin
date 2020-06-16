package charbosses.actions.util;

import charbosses.bosses.AbstractCharBoss;
import charbosses.relics.CBR_Calipers;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.MonsterGroup;
import com.megacrit.cardcrawl.powers.BlurPower;
import downfall.monsters.NeowBoss;
import slimebound.SlimeboundMod;

public class CharBossMonsterGroup extends MonsterGroup {


    public CharBossMonsterGroup(AbstractMonster[] input) {
        super(input);
    }

    @Override
    public void applyPreTurnLogic() {
        SlimeboundMod.logger.info("New Monstergroup preTurnLogic triggered");

        for (AbstractMonster m : this.monsters) {
            AbstractCharBoss cB = (AbstractCharBoss) m;
            if (!m.isDying && !m.isEscaping) {
                if (!m.hasPower("Barricade") && !m.hasPower(BlurPower.POWER_ID)) {
                    if (cB.hasRelic(CBR_Calipers.ID)) {
                        SlimeboundMod.logger.info("Calipers block triggered.");
                        m.loseBlock(15);
                    } else {
                        SlimeboundMod.logger.info("Normal block loss triggered.");
                        m.loseBlock();
                    }
                }

                if (NeowBoss.neowboss != null)
                    if (!NeowBoss.neowboss.offscreen)
                        m.applyStartOfTurnPowers();
            }
        }

    }
}
