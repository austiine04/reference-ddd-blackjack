package org.home.blackjack.core.infrastructure.persistence.table;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.inject.Named;

import org.home.blackjack.core.domain.shared.TableID;
import org.home.blackjack.core.domain.table.Table;
import org.home.blackjack.core.domain.table.TableRepository;
import org.home.blackjack.util.ddd.pattern.events.LightweightDomainEventBus;
import org.home.blackjack.util.locking.FinegrainedLockable;

import com.google.common.collect.Maps;

@Named
public class InMemoryTableRepository implements TableRepository, FinegrainedLockable<TableID> {
	
	private final Map<TableID, Table> map = Maps.newHashMap();
	private final ConcurrentMap<TableID, Lock> locks = Maps.newConcurrentMap();


	@Override
	public Table find(TableID tableID) {
		Table table = map.get(tableID);
		table.setDomainEventPublisher(LightweightDomainEventBus.domainEventPublisherInstance());
		return table;
	}

	@Override
	public void update(Table table) {
		map.put(table.getID(), table);
	}

	@Override
	public void create(Table table) {
		map.put(table.getID(), table);
	}

	@Override
	public void clear() {
		map.clear();
		locks.clear();
	}

	@Override
	public Lock getLockForKey(TableID key) {
        locks.putIfAbsent(key, new ReentrantLock());
        return locks.get(key);
	}

}