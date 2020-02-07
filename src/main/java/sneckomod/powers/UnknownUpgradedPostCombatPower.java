package sneckomod.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.city.Snecko;
import com.megacrit.cardcrawl.powers.AbstractPower;
import sneckomod.SneckoMod;
import sneckomod.util.UpgradedUnknownReward;
import theHexaghost.HexaMod;
import theHexaghost.powers.RemoveMeBabey;
import theHexaghost.util.SealSealReward;
import theHexaghost.util.TextureLoader;

public class UnknownUpgradedPostCombatPower extends AbstractPower implements CloneablePowerInterface {

    public static final String POWER_ID = SneckoMod.makeID("UnknownUpgradedPostCombatPower");

    private static final Texture tex84 = TextureLoader.getTexture(HexaMod.getModID() + "Resources/images/powers/SealAfterCombat84.png");
    private static final Texture tex32 = TextureLoader.getTexture(HexaMod.getModID() + "Resources/images/powers/SealAfterCombat32.png");

    public UnknownUpgradedPostCombatPower(final int amount) {
        this.name = "Post-Combat Upgraded Unknown";
        this.ID = POWER_ID;
        this.owner = AbstractDungeon.player;
        this.amount = amount;
        this.type = PowerType.BUFF;
        this.isTurnBased = true;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);

        this.updateDescription();
    }

    @Override
    public void updateDescription() {
        if (amount > 1)
            description = "At the end of combat, obtain #b" + amount + " additional #yUpgraded #yUnknown cards.";
        else
            description = "At the end of combat, obtain #b" + amount + " additional #yUpgraded #yUnknown card.";
    }

    @Override
    public void onVictory() {
        AbstractDungeon.getCurrRoom().addCardReward(new UpgradedUnknownReward(AbstractDungeon.player.getCardColor()));
    }

    @Override
    public AbstractPower makeCopy() {
        return new UnknownUpgradedPostCombatPower(amount);
    }
}